package InterviewPractice.SupermanCont.F5;

public class Superman {
    private static Superman superman;

    private Superman() {
    }

    public synchronized static Superman getInstance() {

        if (superman == null) {
            superman = new Superman();
        }

        return superman;
    }
}