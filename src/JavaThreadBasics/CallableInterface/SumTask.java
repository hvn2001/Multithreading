package JavaThreadBasics.CallableInterface;

class SumTask implements Callable<Integer> {

    int n;

    public SumTask(int n) {
        this.n = n;
    }

    public Integer call() throws Exception {

        if (n <= 0)
            return 0;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public void call2() throws Exception {
        final int n = 10;
        Callable<Integer> sumTask = new Callable<Integer>() {

            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }
        };
    }
}