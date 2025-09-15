package cucumberTest;

import org.junit.runner.JUnitCore;

public class MainTestRunner {
    public static void main(String[] args) {
        JUnitCore.runClasses(CucumberTestSuite.class);
    }
}