public class Frame {
    private int firstThrow;
    private int secondThrow;
    private boolean strike;
    private boolean spare;

    public Frame() {
        firstThrow = secondThrow = -1;
        strike = true;
        spare = false;
    }

    public boolean add(int pins) {
        if (firstThrow == -1) {
            firstThrow = pins;

            if (firstThrow != 10) {
                strike = false;
            }
        } else if (secondThrow == -1 && !strike) {
            secondThrow = pins;

            if (firstThrow + secondThrow == 10) {
                spare = true;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean isStrike() {
        return strike;
    }

    public int getPins() {
        int result = 0;
        if (firstThrow > 0) {
            result += firstThrow;
        }
        if (secondThrow > 0) {
            result += secondThrow;
        }
        return result;
    }

    public boolean isSpare() {
        return spare;
    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }
}

