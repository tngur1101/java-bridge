package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력 받은 크기의 다리 길이 생성 여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 15, 20, 1, 30})
    void makkeBridge(int size){
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertEquals(bridge.size(), size);
    }
}
