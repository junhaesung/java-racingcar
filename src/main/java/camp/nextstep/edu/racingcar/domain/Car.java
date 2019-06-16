package camp.nextstep.edu.racingcar.domain;

public class Car {
    private static final Car DEFAULT = new Car(0);

    /**
     * 자동차 위치
     */
    private final int position;

    public int getPosition() {
        return position;
    }

    private Car(int position) {
        this.position = position;
    }

    public static Car from(int position) {
        return new Car(position);
    }

    public static Car defaultInstance() {
        return DEFAULT;
    }

    public Car move(int distance) {
        return new Car(position + distance);
    }
}
