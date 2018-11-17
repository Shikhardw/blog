package com.swayam.practice.algos.tree.balanced;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TreeTest {

    @Test
    public void testGetHeight_empty() {
        // given
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();

        // when
        int result = tree.getHeight();

        // then
        assertEquals(0, result);
    }

    @Test
    public void testGetHeight_full() {
        // given
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();
        tree.add(100);
        tree.add(50);
        tree.add(500);
        tree.add(400);
        tree.add(600);
        tree.add(40);
        tree.add(70);

        // when
        int result = tree.getHeight();

        // then
        assertEquals(3, result);
    }

    @Test
    public void testGetBreadth_empty() {
        // given
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();

        // when
        int result = tree.getBreadth();

        // then
        assertEquals(0, result);
    }

    @Test
    public void testGetBreadth_full() {
        // given
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();
        tree.add(100);
        tree.add(50);
        tree.add(500);
        tree.add(400);
        tree.add(600);
        tree.add(40);
        tree.add(70);

        // when
        int result = tree.getBreadth();

        // then
        assertEquals(4, result);
    }

}
