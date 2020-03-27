package InterviewPractice.AsynchronousToSynchronous.F3;

import InterviewPractice.AsynchronousToSynchronous.F0.Callback;
import InterviewPractice.AsynchronousToSynchronous.F0.Executor;

class SynchronousExecutor extends Executor {

    public void asynchronousExecution(Callback callback) throws Exception {
        Object signal = new Object();
        Callback cb = new Callback() {
            @Override
            public void done() {
                callback.done();
                synchronized (signal) {
                    signal.notify();
                }
            }
        };
        // Call the asynchronous executor
        super.asynchronousExecution(cb);
        synchronized (signal) {
            signal.wait();
        }
    }
}