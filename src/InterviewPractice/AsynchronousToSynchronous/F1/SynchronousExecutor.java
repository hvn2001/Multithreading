package InterviewPractice.AsynchronousToSynchronous.F1;

import InterviewPractice.AsynchronousToSynchronous.F0.Callback;
import InterviewPractice.AsynchronousToSynchronous.F0.Executor;

class SynchronousExecutor extends Executor {

    public void asynchronousExecution(Callback callback) throws Exception {
        // Pass something to the base class's asynchronous
        // method implementation that the base class can notify on
        // Call the asynchronous executor
        super.asynchronousExecution(callback);
        // Wait on something that the base class's asynchronous
        // method implementation notifies for
    }

}