import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrameTest {
    Frame currentFrame;

    @BeforeEach
    void setUp() {
        currentFrame = new Frame();
    }

    @Test
    void isSpareReturnsTrueIfSpare() {
        currentFrame.add(2);
        currentFrame.add(8);

        assertTrue(currentFrame.isSpare());
    }

    @Test
    void isSpareReturnsFalseIfNotSpare() {
        currentFrame.add(2);
        currentFrame.add(4);

        assertFalse(currentFrame.isSpare());
    }

    @Test
    void isStrikeReturnsTrueIfStrike() {
        currentFrame.add(10);

        assertTrue(currentFrame.isStrike());
    }

    @Test
    void isStrikeReturnsFalseIfNotStrike() {
        currentFrame.add(3);

        assertFalse(currentFrame.isStrike());
    }

    @Test
    void getPinsReturnsNumberOfPinsCorrectly() {
        currentFrame.add(2);
        currentFrame.add(3);

        assertEquals(5, currentFrame.getPins());
    }

    @Test
    void getFirstThrowReturnsCorrectly() {
        currentFrame.add(2);

        assertEquals(2, currentFrame.getFirstThrow());
    }

    @Test
    void getSecondThrowReturnsCorrectly() {
        currentFrame.add(2);
        currentFrame.add(3);

        assertEquals(3, currentFrame.getSecondThrow());
    }

    @Test
    void getPinsWithASingleThrowWorksCorrectly() {
        currentFrame.add(2);

        assertEquals(2, currentFrame.getPins());
    }
}
