package camp.nextstep.edu.racingcar.domain;

public class Game {
    private final int numberOfCars;
    private final int numberOfRounds;
    private final Rounds rounds;

    private Game(int numberOfCars, int numberOfRounds, Rounds rounds) {
        if (numberOfCars < 0) {
            throw new IllegalArgumentException("'numberOfCars' must be greater than or equal to 0");
        }
        if (numberOfRounds < 0) {
            throw new IllegalArgumentException("'numberOfRounds' must be greater than or equal to 0");
        }
        if (rounds == null) {
            throw new IllegalArgumentException("'rounds' must not be null");
        }
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
        this.rounds = rounds;
    }

    public static Game of(int numberOfCars, int numberOfRounds) {
        return new Game(
                numberOfCars,
                numberOfRounds,
                Rounds.empty()
        );
    }

    public void playOneRound(MovingStrategy movingStrategy) {
        rounds.add(nextRound);
    }

    private boolean isStarted() {
        return rounds.size() > 0;
    }

    private void moveCars(Round round, MovingStrategy movingStrategy) {
        rounds.moveCars(round, movingStrategy);
    }

    private void playFirstRound(MovingStrategy movingStrategy) {
        if (rounds.isEmpty()) {
            final Cars initialCars = Cars.defaultInstance(numberOfCars);
            Round initialRound = Round.from(initialCars);
            moveCars(initialRound, movingStrategy);
            return;
        }
        final Round lastRound = rounds.getLast();
        final Cars cars = lastRound.getCars();
        moveCars(cars, movingStrategy);
    }

    public boolean hasFinished() {
        return rounds.size() == numberOfRounds;
    }

    public Rounds getResult() {
        return rounds;
    }
}
