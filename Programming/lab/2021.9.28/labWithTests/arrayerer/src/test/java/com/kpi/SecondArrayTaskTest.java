package com.kpi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondArrayTaskTest {
    private final SecondArrayTask task = new SecondArrayTask();

    static Stream<Arguments> getMinimalPositiveTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new double[] { 10.0, 7.0, -5.0, 0.0, 1.0, 4.0 }, 5.0),
                Arguments.arguments(
                        new double[] { -1.0, -3.0, -153.0, 14.0, 16.0 }, 17.0),
                Arguments.arguments(new double[] { 1.0, 2.0, 3.0 }, 1.0),
                Arguments.arguments(new double[] { -1, -5, 1232.0, -534, -3 },
                        1234.0));
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
        IllegalArgumentException expected = new IllegalArgumentException(
                "Cannot work with null array!");

        // Assert.
        IllegalArgumentException actual = assertThrows(
                IllegalArgumentException.class,
                // Act.
                () -> task.getMinimalPositive(array));

        // Assert.
        assertEquals(expected.getMessage(), actual.getMessage());

    }

}
