package camp.nextstep.edu.racingcar.domain;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public Integer getDistanceToMove() {
        return RANDOM.nextInt(10) >= 4 ? 1 : 0;
    }
}
