package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.domain.*;
import camp.nextstep.edu.racingcar.view.InputHandler;
import camp.nextstep.edu.racingcar.view.InputView;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.ResultView;
import camp.nextstep.edu.racingcar.view.console.ConsoleInputView;
import camp.nextstep.edu.racingcar.view.console.ConsoleIntegerInputHandler;
import camp.nextstep.edu.racingcar.view.console.ConsoleResultView;
import camp.nextstep.edu.racingcar.view.console.ConsoleStringOutputHandler;
import camp.nextstep.edu.racingcar.view.dto.GameRequest;
import camp.nextstep.edu.racingcar.view.formatter.*;

public class RacingCarApplication {

    private final InputView inputView;
    private final ResultView resultView;
    private final GamePlayer gamePlayer;

    public RacingCarApplication(InputView inputView,
                                ResultView resultView,
                                GamePlayer gamePlayer) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.gamePlayer = gamePlayer;
    }

    public static void main(String[] args) {
        final InputHandler<Integer> inputHandler = new ConsoleIntegerInputHandler();
        final OutputHandler<String> outputHandler = new ConsoleStringOutputHandler();
        final MovingStrategy randomMovingStrategy = new RandomStrategy();
        final GamePlayer gamePlayer = GamePlayer.of(randomMovingStrategy);

        final Formatter<Car> carFormatter = new CarFormatter();
        final Formatter<Cars> carsFormatter = new CarsFormatter(carFormatter);
        final Formatter<Round> roundFormatter = new RoundFormatter(carsFormatter);
        final Formatter<Rounds> roundsFormatter = new RoundsFormatter(roundFormatter);

        final InputView inputView = new ConsoleInputView(inputHandler, outputHandler);
        final ResultView resultView = new ConsoleResultView(outputHandler, roundsFormatter);

        final RacingCarApplication application = new RacingCarApplication(inputView, resultView, gamePlayer);

        application.run();
    }

    public void run() {
        // 입력 두개
        final GameRequest gameRequest = inputView.printAndGetInput();
        // 게임
        final int numberOfCars = gameRequest.getNumberOfCars();
        final int numberOfRounds = gameRequest.getNumberOfRounds();
        gamePlayer.start(numberOfCars, numberOfRounds);
        gamePlayer.playAllRound();
        final Rounds gameResult = gamePlayer.getGameResult();
        // 출력
        resultView.print(gameResult);
    }

}
