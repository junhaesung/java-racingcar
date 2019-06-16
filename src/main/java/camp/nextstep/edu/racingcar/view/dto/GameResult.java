package camp.nextstep.edu.racingcar.view.dto;

import camp.nextstep.edu.racingcar.domain.Rounds;

public class GameResult {
    private final Rounds rounds;

    private GameResult(Rounds rounds) {
        this.rounds = rounds;
    }

    public static GameResult from(Rounds rounds) {
        return new GameResult(rounds);
    }
}
