package BonusQ.PrintingNumberSeries.F0;

import java.util.concurrent.Semaphore;

class PrintNumberSeries {

    private int n;
    private Semaphore zeroSem, oddSem, evenSem;

    public PrintNumberSeries(int n) {
        this.n = n;
    }

    public void PrintZero() {
    }

    public void PrintOdd() {
    }

    public void PrintEven() {
    }
}