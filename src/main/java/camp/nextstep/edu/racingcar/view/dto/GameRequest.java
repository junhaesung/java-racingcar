package camp.nextstep.edu.racingcar.view.dto;

public class GameRequest {
    private final int numberOfCars;
    private final int numberOfRounds;

    private GameRequest(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
    }

    public static GameRequest of(int numberOfCars, int numberOfRounds) {
        return new GameRequest(numberOfCars, numberOfRounds);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
