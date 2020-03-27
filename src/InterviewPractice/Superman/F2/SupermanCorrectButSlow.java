package InterviewPractice.Superman.F2;

public class SupermanCorrectButSlow {

    private static SupermanCorrectButSlow superman;

    private SupermanCorrectButSlow() {

    }

    public static SupermanCorrectButSlow getInstance() {
        synchronized (SupermanCorrectButSlow.class) {
            if (superman == null) {
                superman = new SupermanCorrectButSlow();
            }
        }
        return superman;
    }

    // Object method
    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}