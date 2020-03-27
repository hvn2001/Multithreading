package InterviewPractice.SupermanCont.F2;

public class Superman {
    private static Superman superman;

    static {
        try {
            superman = new Superman();
        } catch (Exception e) {
            // Handle exception here
        }
    }

    private Superman() {
    }

    public static Superman getInstance() {
        return superman;
    }
}