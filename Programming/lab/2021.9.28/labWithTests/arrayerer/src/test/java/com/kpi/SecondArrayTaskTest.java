package com.kpi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondArrayTaskTest {
        private final SecondArrayTask task = new SecondArrayTask();

        static Stream<Arguments> getMinimalPositiveTestCases() {
                return Stream.of(Arguments.arguments(new double[] { 10.0, 7.0, -5.0, 0.0, 1.0, 4.0 }, 5.0),
                                Arguments.arguments(new double[] { -1.0, -3.0, -153.0, 14.0, 16.0 }, 17.0),
                                Arguments.arguments(new double[] { 1.0, 2.0, 3.0 }, 1.0),
                                Arguments.arguments(new double[] { -1, -5, 1232.0, -534, -3 }, 1234.0),
                                Arguments.arguments(new double[] { -1, -2, -3, -4, -5, Double.MAX_VALUE },
                                                Double.MAX_VALUE),
                                Arguments.arguments(new double[] { -1, -2, -3, -4, -5, -6, -7, -8, -9,
                                                Double.POSITIVE_INFINITY }, Double.POSITIVE_INFINITY));
        }

        @ParameterizedTest
        @MethodSource("getMinimalPositiveTestCases")
        @DisplayName("SecondArrayTask.getMinimalPositive happy path")
        void getMinimalPositive(double[] array, double expected) {
                // Arrange.

                // Act.
                double actual = task.getMinimalPositive(array);

                // Assert.
                assertEquals(expected, actual);
        }

        @Test
        @DisplayName("SecondArrayTask.getMinimalPositive null value")
        void getNumberOfPositivesNullValue() {
                // Arrange.
                double[] array = null;

                // Assert.
                IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                                // Act.
                                () -> task.getMinimalPositive(array));

                // Assert.
                IllegalArgumentException expected = new IllegalArgumentException("Cannot work with null array!");
                assertEquals(expected.getMessage(), actual.getMessage());

        }

        static Stream<Arguments> getMinimalPositiveHaventFoundTestCases() {
                return Stream.of(Arguments.arguments(new double[] { -10.0, -7.0, -5.0, 0.0, -1.0, -4.0 }),
                                Arguments.arguments(new double[] { -1.0, -3.0, -153.0, -14.0, -16.0 }),
                                Arguments.arguments(new double[] { -1.0, -2.0, -3.0 }),
                                Arguments.arguments(new double[] { -1, -5, -1232.0, -534, -3 }));
        }

        @ParameterizedTest
        @MethodSource("getMinimalPositiveHaventFoundTestCases")
        @DisplayName("SecondArrayTask.getMinimalPositive No positives")
        void getNumberOfPositivesHaventFound(double[] array) {
                // Arrange.

                // Act.
                double actual = task.getMinimalPositive(array);

                // Assert.
                assertTrue(Double.isNaN(actual), "Expected NaN!");
        }

}
