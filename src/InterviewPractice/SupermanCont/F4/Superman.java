package InterviewPractice.SupermanCont.F4;

public class Superman {
    private static Superman superman;

    private Superman() {
    }

    public static Superman getInstance() {

        if (superman == null) {
            superman = new Superman();
        }

        return superman;
    }
}