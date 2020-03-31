package JavaThreadBasics.FutureInterface.F2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Demonstration {

    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String args[]) throws Exception {
        System.out.println(" sum: " + findSumWithException(10));
        threadPool.shutdown();
        /*
        Something went wrong. java.lang.RuntimeException: something bad happened.
        sum: -1
        * */
    }

    static int findSumWithException(final int n) throws ExecutionException, InterruptedException {

        int result = -1;

        Callable<Integer> sumTask = new Callable<Integer>() {

            public Integer call() throws Exception {
                throw new RuntimeException("something bad happened.");
            }
        };

        Future<Integer> f = threadPool.submit(sumTask);

        try {
            result = f.get();
        } catch (ExecutionException ee) {
            System.out.println("Something went wrong. " + ee.getCause());
        }

        return result;
    }

}