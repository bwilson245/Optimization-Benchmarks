import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    @Test
    public void run_all_tests() {
        TestInterface test0 = new VariableBenchmarkTest();
        TestInterface test1 = new LoopBenchmarkTest();
        TestInterface test2 = new BinarySearchBenchmarkTest();
        TestInterface test3 = new ObjectInstantiationBenchmarkTest();
        TestInterface test4 = new ConcurrencyBenchmarkTest();

        List<TestInterface> tests = List.of(test0, test1, test2, test3, test4);

        for (TestInterface i : tests) {
            i.run();
        }
    }
}
