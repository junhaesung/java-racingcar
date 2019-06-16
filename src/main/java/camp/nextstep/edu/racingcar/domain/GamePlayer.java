package camp.nextstep.edu.racingcar.domain;

public class GamePlayer {
    private Game game;
    private MovingStrategy movingStrategy;

    private GamePlayer(Game game, MovingStrategy movingStrategy) {
        if (movingStrategy == null) {
            throw new IllegalArgumentException("'movingStrategy' must not be null");
        }
        this.game = game;
        this.movingStrategy = movingStrategy;
    }

    public static GamePlayer of(MovingStrategy movingStrategy) {
        return new GamePlayer(null, movingStrategy);
    }

    public void start(int numberOfCars, int numberOfRounds) {
        game = Game.of(numberOfCars, numberOfRounds);
    }

    public void playAllRound() {
        while (!game.hasFinished()) {
            game.playOneRound(movingStrategy);
        }
    }

    public Rounds getGameResult() {
        if (game == null) {
            throw new IllegalStateException("Game is not started.");
        }
        return game.getResult();
    }
}
