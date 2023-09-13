package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class BridgeTest {

    List<String> bridgeList = List.of("U", "U", "D", "D","U","D");
    Bridge bridge = new Bridge(bridgeList);

    @ParameterizedTest
    @CsvSource({"0, U, true", "1,D,false", "2,U,false","3,D,true","4,U,true","5,U,false"})
    void isRightDirection(int index, String direction, boolean result){
        Assertions.assertThat(bridge.isRightDirection(direction, index)).isEqualTo(result);
    }
}
