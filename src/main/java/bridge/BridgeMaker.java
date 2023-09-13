package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private String Up = "U";
    private String Down = "D";
    private int UpNumber = 1;
    private int DownNumber = 0;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();
        for(int i=0;i<size;i++){
            String moveDirection = checkUpOrDown();
            answerBridge.add(moveDirection);
        }

        return answerBridge;
    }

    private String checkUpOrDown(){
        int number = bridgeNumberGenerator.generate();
        if(number == UpNumber){
            return Up;
        }
        if(number == DownNumber){
            return Down;
        }
        return null;
    }
}
