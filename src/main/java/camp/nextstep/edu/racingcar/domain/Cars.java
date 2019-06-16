package camp.nextstep.edu.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 자동차 여러대. 일급컬렉션
 */
public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public static Cars defaultInstance(int size) {
        final List<Car> carList = IntStream.range(0, size)
                .mapToObj(number -> Car.defaultInstance())
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public Stream<Car> stream() {
        return carList.stream();
    }

    public int size() {
        return carList.size();
    }

    public Cars move(MovingStrategy movingStrategy) {
        final List<Car> movedCarList = carList.stream()
                .map(car -> {
                    final int distance = movingStrategy.getDistanceToMove();
                    return car.move(distance);
                })
                .collect(Collectors.toList());
        return new Cars(movedCarList);
    }
}
