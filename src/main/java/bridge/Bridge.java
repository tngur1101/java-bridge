package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    // 생성자
    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    // 건널 수 있는 다리인지 체크
    public boolean isRightDirection(String direction, int index){
        return bridge.get(index).equals(direction);
    }

    // 다리를 전부 건넜는지 체크
    public boolean isCrossedDirection(List<String> visited){
        return visited.size() == bridge.size();
    }
}
