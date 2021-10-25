package com.kpi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;

public class SelectionSorterTest {
    private final ISorter sorter = new SelectionSorter();

    static Stream<Arguments> sortTestCases() {
        return Stream.of(Arguments.arguments(5), Arguments.arguments(5), Arguments.arguments(10),
                Arguments.arguments(10), Arguments.arguments(10), Arguments.arguments(20), Arguments.arguments(20),
                Arguments.arguments(50));
    }

    @ParameterizedTest
    @MethodSource("sortTestCases")
    @DisplayName("SelectionSorter.sort")
    void sort(int length) {
        // Arrange.
        // Create random array
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        // Act.
        sorter.sort(array);

        // Assert.
        for (int i = 0; i < length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}
