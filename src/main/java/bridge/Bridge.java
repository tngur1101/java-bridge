package bridge;

import java.util.List;

public class Bridge {
    private List<String> answerBridge;

    // 생성자
    public Bridge(List<String> answerBridge){
        this.answerBridge = answerBridge;
    }

    // 건널 수 있는 다리인지 체크
    public boolean isRightDirection(String direction, int index){
        if(answerBridge.get(index).equals(direction)){
            return true;
        }
        return false;
    }

    // 다리를 전부 건넜는지 체크
    public boolean isCrossedDirection(List<String> visited){
        if(visited.size() == answerBridge.size()){
            return true;
        }
        return false;
    }
}
