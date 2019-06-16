package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.InputHandler;
import camp.nextstep.edu.racingcar.view.InputView;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.dto.GameRequest;

public class ConsoleInputView implements InputView {

    private static final String MESSAGE_FOR_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_FOR_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

    private final InputHandler<Integer> consoleIntegerInputHandler;
    private final OutputHandler<String> consoleStringOutputHandler;

    public ConsoleInputView(InputHandler<Integer> consoleIntegerInputHandler,
                            OutputHandler<String> consoleStringOutputHandler) {
        this.consoleIntegerInputHandler = consoleIntegerInputHandler;
        this.consoleStringOutputHandler = consoleStringOutputHandler;
    }

    @Override
    public GameRequest printAndGetInput() {
        consoleStringOutputHandler.handle(MESSAGE_FOR_NUMBER_OF_CARS);
        final int numberOfCars = consoleIntegerInputHandler.getInput();

        consoleStringOutputHandler.handle(MESSAGE_FOR_NUMBER_OF_ROUNDS);
        final int numberOfRounds = consoleIntegerInputHandler.getInput();

        return GameRequest.of(numberOfCars, numberOfRounds);
    }
}
