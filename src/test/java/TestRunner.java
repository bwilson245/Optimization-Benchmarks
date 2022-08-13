import org.junit.jupiter.api.Test;

import java.util.List;

public class TestRunner {

    @Test
    public void run_all_tests() {
        TestInterface test0 = new VariableOptimizationsTest();
        TestInterface test1 = new LoopOptimizationsTest();
        TestInterface test2 = new BinarySearchOptimizationsTest();
        TestInterface test3 = new ObjectInstantiationOptimizationsTest();
        TestInterface test4 = new ConcurrencyOptimizationsTest();
        TestInterface test5 = new BinaryTreeOptimizationsTest();

        List<TestInterface> tests = List.of(test0, test1, test2, test3, test4, test5);

        for (TestInterface i : tests) {
            i.run();
        }
    }
}
