package com.kpi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstArrayTaskTest {
    private final FirstArrayTask task = new FirstArrayTask();

    static Stream<Arguments> getNumberOfPositivesArguments() {
        return Stream.of(
                Arguments.arguments(new double[] { 2.0, 3.0, -5.0, 0.0, 14.0 },
                        3.0),
                Arguments.arguments(new double[] { 1.0 }, 1),
                Arguments.arguments(new double[] { 1.0, 2.0, 3.0 }, 3),
                Arguments.arguments(new double[] { -1, -5, -3, -534, -3 },
                        0.0));
    }

    @ParameterizedTest
    @MethodSource("getNumberOfPositivesArguments")
    @DisplayName("FirstArrayTask.getNumberOfPositives happy path")
    void getNumberOfPositives(double[] array, double expected) {
        // Arrange.

        // Act.
        double actual = task.getNumberOfPositives(array);

        // Assert.
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("FirstArrayTask.getNumberOfPositives null value")
    void getNumberOfPositivesNullValue() {
        // Arrange.
        double[] array = null;
        IllegalArgumentException expected = new IllegalArgumentException(
                "Cannot work with null array!");

        // Assert.
        IllegalArgumentException actual = assertThrows(
                IllegalArgumentException.class,
                // Act.
                () -> task.getNumberOfPositives(array));

        // Assert.
        assertEquals(expected.getMessage(), actual.getMessage());

    }

}
