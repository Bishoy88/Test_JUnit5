package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTest {
    @org.junit.jupiter.api.RepeatedTest(5)
    void firstRepeatedMethod() {
        System.out.println("We are repeating this test");
    }
    @org.junit.jupiter.api.RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}. Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondRepeatedMethod() {
        System.out.println("We are running a new test");
    }
    @org.junit.jupiter.api.RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo){
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3, () -> System.out.println("This code only run in repetition 3"));
    }
}
