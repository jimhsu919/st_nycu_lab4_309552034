import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();
    private static Stream<Arguments> p1WinCase() {
        return Stream.of(
                Arguments.of("rock", "scissors", "Player 1 win!"),
                Arguments.of("paper", "rock", "Player 1 win!"),
                Arguments.of("scissors", "paper", "Player 1 win!")
        );
    }

    private static Stream<Arguments> p2WinCase() {
        return Stream.of(
                Arguments.of("scissors", "rock" ,"Player 2 win!"),
                Arguments.of("rock", "paper", "Player 2 win!"),
                Arguments.of("paper", "scissors", "Player 2 win!")
        );
    }

    private static Stream<Arguments> drawCase() {
        return Stream.of(
                Arguments.of("rock", "rock", "Draw!"),
                Arguments.of("paper", "paper", "Draw!"),
                Arguments.of("scissors", "scissors", "Draw!")
        );
    }

    private static Stream<Arguments> isValidCase() {
        return Stream.of(
                Arguments.of("rock!", false),
                Arguments.of("paper", true),
                Arguments.of("scissssors", false),
                Arguments.of("zzzzzz", false),
                Arguments.of("rock", true)
        );
    }


    @ParameterizedTest(name = "#{index} - Test with argument={0},{1},{2}")
    @MethodSource("p1WinCase")
    void p1Win(String p1, String p2, String ret) {
        assertEquals(ret, game.getWinner(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0},{1},{2}")
    @MethodSource("p2WinCase")
    void p2Win(String p1, String p2, String ret) {
        assertEquals(ret, game.getWinner(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0},{1},{2}")
    @MethodSource("drawCase")
    void Draw(String p1, String p2, String ret) {
        assertEquals(ret, game.getWinner(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0},{1}")
    @MethodSource("isValidCase")
    void invalid_input(String s, boolean b) {
        if(b) {
            assertDoesNotThrow(() -> {
                game.inputChecker(s);
            });
        }
        else {
            assertThrows(IllegalArgumentException.class, () -> {
                game.inputChecker(s);
            });
        }
    }
}
