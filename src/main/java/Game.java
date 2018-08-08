import java.util.ArrayList;

public class Game {

    private ArrayList<Frame> frames;

    public Game() {
        frames = new ArrayList<Frame>();
    }

    public void roll(int pins) {
        if (frames.size() == 0 || frameDone()) {
            frames.add(new Frame());
        }
        frames.get(frames.size() - 1).add(pins);
    }

    private boolean frameDone() {
        return frames.get(frames.size() - 1).isStrike() || frames.get(frames.size() - 1).getSecondThrow() != -1;
    }

    public int score() {
        int score = 0;
        boolean hasSpareBonus = false;
        boolean hasStrikeBonus = false;
        int framesProcessed = 0;

        for (Frame frame : frames) {
            if (framesProcessed < 10) {
                score += frame.getPins();
            }

            if (hasSpareBonus) {
                score += frame.getFirstThrow();
                hasSpareBonus = false;
            } else if (hasStrikeBonus) {
                score += frame.getPins();
                hasStrikeBonus = false;
            }
            if (frame.isStrike()) {
                hasStrikeBonus = true;
            } else if (frame.isSpare()) {
                hasSpareBonus = true;
            }

            framesProcessed++;
        }

        return score;
    }
}
