package Warmup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    //Teacher tips: Don't name it 'Test', name the test around what your goal is.

class TestLabChocolate {
    @Test
    void makeChocolate_smallAndBigAddsUpToGoal() {
        int expected = 4;
        int actual = LabChocolate.makeChocolate(4, 1, 9);
        assertEquals(expected, actual);
    }

    @Test
    void makeChocolate_notEnoughChocolate() {
        assertEquals(-1, LabChocolate.makeChocolate(4, 1, 10));
    }

    @Test
    void makeChocolate_exactBigBars() {
        int expected = 0;
        int actual = LabChocolate.makeChocolate(4, 1, 5);
        assertEquals(expected, actual);
    }

    @Test
    void makeChocolate_weirdRemainder(){
        int expected = 6;
        int actual = LabChocolate.makeChocolate(1000, 1000000, 5000006);
        assertEquals(expected, actual);
    }

    @Test
    void makeChocolate_bigMulti5(){
        int expected = 50;
        int actual = LabChocolate.makeChocolate(60, 100, 550);
        assertEquals(expected, actual);
    }
}