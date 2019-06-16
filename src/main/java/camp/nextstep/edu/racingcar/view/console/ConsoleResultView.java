package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.domain.Rounds;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.ResultView;
import camp.nextstep.edu.racingcar.view.formatter.Formatter;

public class ConsoleResultView implements ResultView {

    private final OutputHandler<String> outputHandler;
    private final Formatter<Rounds> roundsFormatter;

    public ConsoleResultView(OutputHandler<String> outputHandler,
                             Formatter<Rounds> roundsFormatter) {
        this.outputHandler = outputHandler;
        this.roundsFormatter = roundsFormatter;
    }

    @Override
    public void print(Rounds rounds) {
        String title = "실행 결과";
        String content = roundsFormatter.format(rounds);
        outputHandler.handle(title + "\n" + content);
    }
}
