import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void scoreCalculatesASpare() {
        Game currentGame = new Game();

        //First Frame
        currentGame.roll(4);
        currentGame.roll(6);

        //Second Frame
        currentGame.roll(4);

        assertEquals(18, currentGame.score());
    }

    @Test
    void scoreCalculatesAStrike() {
        Game currentGame = new Game();

        currentGame.roll(10);

        //Second Frame
        currentGame.roll(4);
        currentGame.roll(4);

        assertEquals(26, currentGame.score());
    }

    @Test
    void scoreCalculatesASingleFrame() {
        Game currentGame = new Game();

        //First Frame
        currentGame.roll(4);
        currentGame.roll(4);

        //Second Frame
        currentGame.roll(3);
        currentGame.roll(3);

        assertEquals(14, currentGame.score());
    }

    @Test
    void scoreCalculatesOnlyTheFirstTenFrames() {
        Game currentGame = new Game();

        for(int i = 0; i < 22; i++) {
            currentGame.roll(1);
        }

        assertEquals(20, currentGame.score());
    }

    @Test
    void scoreCalculatesExtraFrameIfTenthFrameIsASpare() {
        Game currentGame = new Game();

        for(int i = 0; i < 19; i++) {
            currentGame.roll(1);
        }

        currentGame.roll(9);

        currentGame.roll(4);

        assertEquals(32, currentGame.score());
    }

    @Test
    void scoreCalculatesTwoExtraFramesIfTenthFrameIsAStrike() {
        Game currentGame = new Game();

        for(int i = 0; i < 18; i++) {
            currentGame.roll(1);
        }

        currentGame.roll(10);

        currentGame.roll(4);
        currentGame.roll(5);

        assertEquals(37, currentGame.score());
    }
}
