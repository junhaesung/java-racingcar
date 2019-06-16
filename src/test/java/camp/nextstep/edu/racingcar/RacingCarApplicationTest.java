package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.domain.GamePlayer;
import camp.nextstep.edu.racingcar.domain.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarApplicationTest {

    private RacingCarApplication application;

    @BeforeEach
    void setup() {
        final GamePlayer gamePlayer = GamePlayer.of(new RandomStrategy());
        application = new RacingCarApplication(() -> 3, consoleStringOutputHandler, gamePlayer);
    }

    @Test
    void 정수2개_입력받을_수_있어야함() {
        application.run();
    }

    @Test
    void 실행하면_게임결과가_출력되는지() {
        application.run();
    }

}