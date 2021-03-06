package com.swayam.practice.algos.sort.mergesort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSort2Test {

    @Test
    public void testSort_length_1() {
        // given
        int[] input = new int[] { 40 };
        MergeSort2 testClass = new MergeSort2();

        // when
        int[] result = testClass.sort(input);

        // then
        assertArrayEquals(new int[] { 40 }, result);
    }

    @Test
    public void testSort_even_length() {
        // given
        int[] input = new int[] { 40, 2, 54, 1, 8, 11, 95, 10 };
        MergeSort2 testClass = new MergeSort2();

        // when
        int[] result = testClass.sort(input);

        // then
        assertArrayEquals(new int[] { 1, 2, 8, 10, 11, 40, 54, 95 }, result);
    }

    @Test
    public void testSort_odd_length() {
        // given
        int[] input = new int[] { 40, 2, 54, 1, 8, 11, 95, 10, 57 };
        MergeSort2 testClass = new MergeSort2();

        // when
        int[] result = testClass.sort(input);

        // then
        assertArrayEquals(new int[] { 1, 2, 8, 10, 11, 40, 54, 57, 95 }, result);
    }

}
