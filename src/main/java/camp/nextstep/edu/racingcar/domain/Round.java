package camp.nextstep.edu.racingcar.domain;

public class Round {
    private final Cars cars;

    private Round(Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException("'cars' must not be null");
        }
        this.cars = cars;
    }

    public static Round from(Cars cars) {
        return new Round(cars);
    }

    public Cars getCars() {
        return cars;
    }
}
