import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrameTest {
    @Test
    void isSpareReturnsTrueIfSpare() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);
        currentFrame.add(8);

        assertTrue(currentFrame.isSpare());
    }

    @Test
    void isSpareReturnsFalseIfNotSpare() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);
        currentFrame.add(4);

        assertFalse(currentFrame.isSpare());
    }

    @Test
    void isStrikeReturnsTrueIfStrike() {
        Frame currentFrame = new Frame();

        currentFrame.add(10);

        assertTrue(currentFrame.isStrike());
    }

    @Test
    void isStrikeReturnsFalseIfNotStrike() {
        Frame currentFrame = new Frame();

        currentFrame.add(3);

        assertFalse(currentFrame.isStrike());
    }

    @Test
    void getPinsReturnsNumberOfPinsCorrectly() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);
        currentFrame.add(3);

        assertEquals(5, currentFrame.getPins());
    }

    @Test
    void getFirstThrowReturnsCorrectly() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);

        assertEquals(2, currentFrame.getFirstThrow());
    }

    @Test
    void getSecondThrowReturnsCorrectly() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);
        currentFrame.add(3);

        assertEquals(3, currentFrame.getSecondThrow());
    }

    @Test
    void getPinsWithASingleThrowWorksCorrectly() {
        Frame currentFrame = new Frame();

        currentFrame.add(2);

        assertEquals(2, currentFrame.getPins());
    }
}
