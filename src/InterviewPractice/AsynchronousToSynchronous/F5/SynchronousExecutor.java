package InterviewPractice.AsynchronousToSynchronous.F5;

import InterviewPractice.AsynchronousToSynchronous.F0.Callback;
import InterviewPractice.AsynchronousToSynchronous.F0.Executor;

class SynchronousExecutor extends Executor {
    @Override
    public void asynchronousExecution(Callback callback) throws Exception {
        Object signal = new Object();
        final boolean[] isDone = new boolean[1];
        Callback cb = new Callback() {
            @Override
            public void done() {
                callback.done();
                synchronized (signal) {
                    signal.notify();
                    isDone[0] = true;
                }
            }
        };
        // Call the asynchronous executor
        super.asynchronousExecution(cb);
        synchronized (signal) {
            while (!isDone[0]) {
                signal.wait();
            }
        }
    }
}