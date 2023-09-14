package bridge;

import View.InputView;
import View.OutputView;

import java.util.List;
import java.util.UUID;

public class Application {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static BridgeGame bridgeGame = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStartGame();
        try{
            init();
            startGame();
            showGameResult();
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
        }
    }
    private static void init(){
        try{
            String input = InputView.readBridgeSize();
            bridgeGame.init(input);
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            init();
        }
    }

    private static void showGameResult() {
        OutputView.printEnding();
        printBridge();
        String result = bridgeGame.getGameResult();
        int tryNumber = bridgeGame.getTRY_NUMBER();
        OutputView.printResult(result, tryNumber);
    }

    private static void printBridge() {
        List<String> bridgeUp = bridgeGame.getBridge(UP);
        List<String> bridgeDown = bridgeGame.getBridge(DOWN);

        OutputView.printMap(bridgeUp);
        OutputView.printMap(bridgeDown);
    }

    private static void startGame() {
        while (true){
            if (bridgeGame.isGameDone()){
                OutputView.printEnter();
                break;
            }

            if(!move() && !retry()){
                break;
            }
        }
    }

    private static boolean move(){
        String direction = InputView.readMoving();
        boolean isGoodtoGo = bridgeGame.move(direction);
        printBridge();

        return isGoodtoGo;
    }

    private static boolean retry(){
        String word = InputView.readGameCommand();
        return bridgeGame.retry(word);
    }
}
