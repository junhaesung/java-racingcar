package camp.nextstep.edu.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 여러 라운드를 나타내는 클래스
 * round 의 일급 컬렉션
 */
public class Rounds {
    private static final Rounds EMPTY = new Rounds(Collections.emptyList());

    private final List<Round> roundList;

    private Rounds(List<Round> roundList) {
        if (roundList == null) {
            throw new IllegalArgumentException("'roundList' must not be null");
        }
        this.roundList = new ArrayList<>(roundList);
    }

    public static Rounds from(List<Round> roundList) {
        return new Rounds(roundList);
    }

    public static Rounds empty() {
        return EMPTY;
    }

    public int size() {
        return roundList.size();
    }

    public void add(Round round) {
        if (round == null) {
            throw new IllegalArgumentException("'round' must not be null");
        }
        roundList.add(round);
    }

    public Stream<Round> stream() {
        return roundList.stream();
    }

    public boolean isEmpty() {
        return roundList.isEmpty();
    }

    public Round getLast() {
        final int size = roundList.size();
        return roundList.get(size - 1);
    }

    public Round moveCars(Round previousRound, MovingStrategy movingStrategy) {
        final Cars cars = previousRound.getCars();
        final Cars movedCars = cars.move(movingStrategy);
        return Round.from(movedCars);
    }
}
