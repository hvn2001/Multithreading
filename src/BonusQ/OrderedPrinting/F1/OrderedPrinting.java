package BonusQ.OrderedPrinting.F1;

class OrderedPrinting {
    private volatile int flag;

    public OrderedPrinting() {
        flag = 1;
    }

    public void printFirst() throws InterruptedException {
        //infinite loop keeps checking in case flag doesn't match
        for (; ; ) {
            if (flag == 1) {
                System.out.println("First");
                //for second printing, increment flag
                flag = 2;
                break;
            }
        }
    }

    public void printSecond() throws InterruptedException {
        for (; ; ) {
            if (flag == 2) {
                System.out.println("Second");
                //for third printing, increment flag
                flag = 3;
                break;
            }
        }
    }

    public void printThird() throws InterruptedException {
        for (; ; ) {
            if (flag == 3) {
                System.out.println("Third");
                //reset flag value to ensure ordered printing
                flag = 1;
                break;
            }
        }
    }
}
