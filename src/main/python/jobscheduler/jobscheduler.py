"""
We want to create a simple job scheduler that runs tasks after a specified amount of time.

It should implement an interface like this:

interface JobScheduler {
  void schedule(Runnable task, long delayMs);
}

The scheduler should handle executing the tasks.
Tasks should run promptly at their timeout if nothing else is running, but it's ok to fall behind the schedule if tasks
 take too long to execute and block other tasks.

Do not use any built-in schedulers for your language. However, you can use other concurrency utilities.

Discussion points:

Ensure correctness of scheduling, especially making sure a simple case of scheduling one task with a long delay, then a
 second with short delay executes the second one promptly upon its delay.

 (For example, just using PriorityBlockingQueue and sleeping on the peek()'d first item is not sufficient)

Ensure correctness when going from empty to non-empty, i.e. that they properly wake up the other thread.
Additional features if there is sufficient time:

Multiple threads for executing tasks

Add support for cancelling tasks
    void cancel(Runnable task);

"""

import queue
import time
import threading

def seconds(millis):
    return millis/1000.


def current_time():
    return int(time.time() * 1000)


class Scheduler:
    def __init__(self):
        self.tasks = queue.PriorityQueue()
        self.closing = False
        self.cx = threading.Condition()

    def submit(self, task, delay_ms):
        if self.closing:
            raise ValueError("Scheduler cannot accept new tasks while closing")

        self.cx.acquire()
        try:
            deadline = current_time() + delay_ms
            self.tasks.put((deadline, task))
            self.cx.notify()
        finally:
            self.cx.release()

    def run(self):
        while not(self.closing):
            self.cx.acquire()
            try:
                if self.tasks.empty():
                    self.cx.wait()
                    continue

                deadline, task = self.tasks.get_nowait()
                now = current_time()
                if deadline < now:
                    task()
                    self.tasks.task_done()
                else:
                    self.tasks.task_done()
                    self.tasks.put((deadline, task))
                    sleep_duration = seconds(deadline - now)
                    self.cx.wait(sleep_duration)
            finally:
                self.cx.release()


    def drain(self):
        self.tasks.join()


    def close(self):
        self.cx.acquire()
        try:
            self.closing = True
            self.cx.notify()
        finally:
            self.cx.release()

def task(_id, duration=500):
    def thunk():
        print("Task %s running" % _id)
        time.sleep(seconds(duration))
        print("Task %s finished" % _id)
    return thunk

if __name__ == '__main__':
    scheduler = Scheduler()
    thread = threading.Thread(target=scheduler.run)
    thread.start()
    scheduler.submit(task("A"), 1000)
    scheduler.submit(task("B"), 5)
    scheduler.submit(task("C"), 400)
    scheduler.drain()
    scheduler.close()
    thread.join()