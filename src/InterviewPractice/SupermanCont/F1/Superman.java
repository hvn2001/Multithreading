package InterviewPractice.SupermanCont.F1;

public class Superman {
    private static final Superman superman = new Superman();

    private Superman() {
    }

    public static Superman getInstance() {
        return superman;
    }
}