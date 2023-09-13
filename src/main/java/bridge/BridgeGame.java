package bridge;

import Util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private int TRY_NUMBER = 1;
    private boolean GAME_RESULT = true;

    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;
    private List<String> visited = new ArrayList<>();
    private static Validator validator = new Validator();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void init(String input){
        validator.validateBridgeNumber(input, MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH);
        int bridgeLength = Integer.parseInt(input);
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeLength);
        bridge = new Bridge(bridgeList);
    }

    public void move() {

    }

    private boolean isGameDone(){
        if(bridge.isCrossedDirection(visited) && GAME_RESULT){
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String word) {
        validator.validateWord(word, RESTART, QUIT);
        if(word.equals(RESTART)){
            reInit();
            return true;
        }
        return false;
    }

    private void reInit() {
        visited = new ArrayList<>();
        TRY_NUMBER += 1;
        GAME_RESULT = true;
    }

    public int getTRY_NUMBER(){
        return TRY_NUMBER;
    }

    public String getGameResult(){
        String result = "실패";
        if(isGameDone()){
            result = "성공";
        }
        return result;
    }
}
