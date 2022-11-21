package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    @Test
    @DisplayName("BridgeGame 객체 생성 테스트")
    void createBridgeGame() {
        BridgeGame bg = new BridgeGame(3);
        assertThat(bg.getBridgeLength()).isEqualTo(3);
        assertThat(bg.getAnswer().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 이동 테스트")
    void userMoveTest() {
        User user = new User(List.of("D","U","D","D"),4);
        user.userMove("D");
        assertThat(user.getUserSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("재시작시 객체 초기화 테스트")
    void gameClearTest() {
        User user = new User(List.of("D","U","D"),3);
        user.userMove("D");
        BridgeGame bg = new BridgeGame(3);
        bg.setGame();
        assertThat(user.getUserSize()==bg.getUserBridge().size()).isEqualTo(false);
    }
}