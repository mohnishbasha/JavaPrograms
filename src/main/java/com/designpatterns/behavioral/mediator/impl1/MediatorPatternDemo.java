package com.designpatterns.behavioral.mediator.impl1;


/*
https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm

Mediator pattern is used to reduce communication complexity between multiple objects or classes. This pattern provides
 a mediator class which normally handles all the communications between different classes and supports easy maintenance
  of the code by loose coupling. Mediator pattern falls under behavioral pattern category.

Implementation
We are demonstrating mediator pattern by example of a chat room where multiple users can send message to chat room and
it is the responsibility of chat room to show the messages to all users. We have created two classes ChatRoom and User.
 User objects will use ChatRoom method to share their messages.

MediatorPatternDemo, our demo class, will use User objects to show communication between them.
 */

/*
Step 3
Use the User object to show communications between them.

MediatorPatternDemo.java
 */

/*
Step 4
Verify the output.

Thu Jan 31 16:05:46 IST 2013 [Robert] : Hi! John!
Thu Jan 31 16:05:46 IST 2013 [John] : Hello! Robert!
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}