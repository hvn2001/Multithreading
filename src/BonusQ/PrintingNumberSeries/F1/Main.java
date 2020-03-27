package BonusQ.PrintingNumberSeries.F1;

public class Main {

    public static void main(String[] args) {

        PrintNumberSeries zeo = new PrintNumberSeries(5);

        Thread t1 = new PrintNumberSeriesThread(zeo, "zero");
        Thread t2 = new PrintNumberSeriesThread(zeo, "even");
        Thread t3 = new PrintNumberSeriesThread(zeo, "odd");

        t2.start();
        t1.start();
        t3.start();
        // 0102030405
    }
}