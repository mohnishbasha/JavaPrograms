package com.designpatterns.behavioral.observer.g4g;

/*
G4g: Concept
http://www.geeksforgeeks.org/observer-pattern-set-2-implementation/

G4G: Implementation
http://www.geeksforgeeks.org/observer-pattern-set-1-introduction/


 */

// Driver Class
public class Cricket
{
    public static void main(String args[])
    {
        // create objects for testing
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();

        // pass the displays to Cricket data
        CricketData cricketData = new CricketData();

        // register display elements
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        // in real app you would have some logic to
        // call this function when data changes
        cricketData.dataChanged();

        //remove an observer
        cricketData.unregisterObserver(averageScoreDisplay);

        // now only currentScoreDisplay gets the
        // notification
        cricketData.dataChanged();
    }
}

/*
        Output:

        Average Score Display:
        Run Rate: 8.823529
        PredictedScore: 441

        Current Score Display:
        Runs: 90
        Wickets:2
        Overs: 10.2

        Current Score Display:
        Runs: 90
        Wickets:2
        Overs: 10.2
*/