import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.ArrayList;

public class TestExecutor {

    public static void main(String[] args) {
        TestExecutor.textExecutor();
    }

    public static void textExecutor() {

        ArrayList<Class<?>> arr = new ArrayList<Class<?>>();
        String packageName = "test.";

        ArrayList<String> classList = new ArrayList<String>();
        classList.add("APIGetRequest");
        classList.add("SampleTest");

        for (String clsName : classList
        ) {
            try {
                arr.add(Class.forName(packageName + clsName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        Result result = junit.run(arr.stream().toArray(Class<?>[]::new)
        );

        resultReport(result);
    }

    public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms.");
    }
}
