package com;

import com.methods.AddMethodTest;
import com.methods.ContainsMethodTest;
import com.optimizations.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestRunner {

    @Test
    public void run_all_tests() throws InvocationTargetException, IllegalAccessException {
        OptimizationsInterface test0 = new VariableOptimizationsTest();
        OptimizationsInterface test2 = new BinarySearchOptimizationsTest();
        OptimizationsInterface test3 = new ObjectInstantiationOptimizationsTest();
        OptimizationsInterface test4 = new ConcurrencyOptimizationsTest();
        OptimizationsInterface test5 = new BinaryTreeOptimizationsTest();
        OptimizationsInterface test6 = new ContainsMethodTest();
        OptimizationsInterface test7 = new AddMethodTest();
        OptimizationsInterface test8 = new LoopsAndStreamsOptimizationsTest();

        List<OptimizationsInterface> tests = List.of(test0, test2, test3, test4, test5, test6, test7, test8);

        for (OptimizationsInterface i : tests) {
            for (Method m : i.getClass().getDeclaredMethods()) {
                m.invoke(i);
            }
        }
    }
}
