package main.rice;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;

/**
 * Simple Main class that programmatically executes all test cases in LinkedListTest.java
 * and prints the results.
 */
public class Main {

    /**
     * Simple main method that programmatically executes all test cases in
     * LinkedListTest.java and pretty-prints the results.
     *
     * @param args command-line args; none expected
     * @throws MalformedURLException  if the test class cannot be found
     * @throws ClassNotFoundException if the test class cannot be found
     */
    public static void main(String[] args) throws MalformedURLException,
        ClassNotFoundException {

        TestExecutionSummary summary = runAllTests();
        printSummary(summary);
    }

    /**
     * Runs all test cases in LinkedListTest.java and returns the results in the form of a
     * TestExecutionSummary object.
     *
     * @return a TestExecutionSummary object encapsulating the results of testing
     */
    private static TestExecutionSummary runAllTests() throws MalformedURLException,
        ClassNotFoundException {

        // Create a request to run all tests in LinkedListTest.java
        URL url = FileSystems.getDefault().getPath("").toUri().toURL();
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        Class<?> c = loader.loadClass("test.rice.LinkedListTest");
        LauncherDiscoveryRequest request =
            LauncherDiscoveryRequestBuilder.request().selectors(selectClass(c)).build();

        // Execute the request to run all tests
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        // Return a summary of the results
        return listener.getSummary();
    }

    /**
     * Pretty-prints the results of testing.
     *
     * @param summary a TestExecutionSummary object encapsulating the results of testing
     */
    private static void printSummary(TestExecutionSummary summary) {
        // Get the number of tests that passed & failed
        long numTests = summary.getTestsStartedCount();
        long numFailed = summary.getTestsFailedCount();
        long numPassed = numTests - numFailed;

        if (numPassed == numTests) {
            System.out.println("All tests passed!");
        } else {
            // Print the number of tests that passed & failed
            System.out.println("\n" + numPassed + " test(s) passed!");
            System.out.println("\n" + numFailed + " test(s) failed:");

            // For each failed test, print the name of the test function, the expected
            // result, and the actual result
            for (TestExecutionSummary.Failure failure : summary.getFailures()) {
                System.out.println("\t" + failure.getTestIdentifier().getDisplayName());
                System.out.println("\t\t" + failure.getException().getMessage() + "\n");
            }
        }
    }
}
