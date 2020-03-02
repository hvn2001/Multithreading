package Basics.CriticalSectionsRaceConditions8;
// Critical Sections & Race Conditions
/*
For the impatient, the fix is presented below where we guard the read and write
of the randInt variable using the RaceCondition object as the monitor.
* */

import java.util.*;

class DemonstrationFixedRace {

    public static void main(String args[]) throws InterruptedException {
        FixedRaceCondition.runTest();
    }
}

class FixedRaceCondition {

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            synchronized (this) {
                if (randInt % 5 == 0) {
                    if (randInt % 5 != 0)
                        System.out.println(randInt);
                }
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {
            synchronized (this) {
                randInt = random.nextInt(1000);
                i--;
            }
        }
    }

    public static void runTest() throws InterruptedException {


        final FixedRaceCondition rc = new FixedRaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}