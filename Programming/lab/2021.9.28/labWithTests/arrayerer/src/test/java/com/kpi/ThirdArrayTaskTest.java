package com.kpi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ThirdArrayTaskTest {
    private final ThirdArrayTask task = new ThirdArrayTask();

    static Stream<Arguments> makeArrayTestCases() {
        return Stream.of(
                //These two are just general usage of method
                Arguments.arguments(new double[] { -11, 7, 4, 1, 11, 10, -2, 0, 9, 11 },
                        new double[] { -20, 6, 15, -15, 8, -13, 19, 20, 0, 1 },
                        new double[] { 220, 13, 19, 0, 19, 0, 0, 0, 0, 12 }),
                Arguments.arguments(new double[] { 1, 2, 3, -1, -2, -3, 1, -2, 3, 0 },
                        new double[] { 1, 2, 3, -1, -2, -3, -1, 2, -3, 0 },
                        new double[] { 2, 4, 6, 1, 4, 9, 0, 0, 0, 0 }),
                        //These are specialized
                        //If both elements are positive - resulting is summ
                Arguments.arguments(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                        new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                        new double[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 }),
                        //If both elements are negative - rusulting is multiplication
                Arguments.arguments(new double[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 },
                        new double[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 },
                        new double[] { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 }),
                        //All other cases - resulting is zero
                Arguments.arguments(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                        new double[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 },
                        new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }),
                        //Using extrime values
                Arguments.arguments(
                        new double[] { 0.5, -0.5, 0.5, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                                Double.POSITIVE_INFINITY, Double.MAX_VALUE },
                        new double[] { 0.5, -0.5, -0.5, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                                Double.NEGATIVE_INFINITY, Double.MAX_VALUE },
                        new double[] { 1, 0.25, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0,
                                Double.POSITIVE_INFINITY }));
    }

    @ParameterizedTest
    @MethodSource("makeArrayTestCases")
    @DisplayName("ThirdArrayTask.makeArray happy path")
    void makeArray(double[] arr1, double[] arr2, double[] expected) {
        // Arrange.

        // Act.
        double[] actual = task.makeArray(arr1, arr2);

        // Assert.
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    static Stream<Arguments> makeArrayThrowsExeptionTestCases() {
        return Stream.of(Arguments.arguments(null, new double[] { 1 }), Arguments.arguments(new double[] { 1 }, null),
                Arguments.arguments(new double[] { 1, 2 }, new double[] { 1 }));
    }

    @ParameterizedTest
    @MethodSource("makeArrayThrowsExeptionTestCases")
    @DisplayName("ThirdArrayTask.makeArray throws exeption invalid imput")
    void makeArrayThrowsExeption(double[] arr1, double[] arr2) {
        // Arrange.

        // Assert.
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                // Act.
                () -> task.makeArray(arr1, arr2));

        // Assert.
        IllegalArgumentException expected = new IllegalArgumentException("Please enter valid imput!");
        assertEquals(expected.getMessage(), actual.getMessage());

    }
}
