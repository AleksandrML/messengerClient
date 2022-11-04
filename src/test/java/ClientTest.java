import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testLogger() {
        // given:
        String clientMessage = "hi";

        // when:
        String result = Logger.getLoggerMessage(clientMessage);

        // then:
        Assertions.assertTrue(result.contains(clientMessage));
    }

}
