package Tests;

import OX.Player;
import OX.Table;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by adrabik on 18.02.16.
 */
public class OX_OOP_EndToEnd {
    public static Table table;
    @BeforeMethod
    public static void clearTable(){
        table = new Table();
    }
    @Test
    public static void playerOneWins(){
        Player player1 = Player.playerSelection(Player.X_SIGN, table);
        Player player2 = Player.playerSelection(Player.O_SIGN, table);

        player1.move("1");
        player2.move("3");
        player1.move("4");
        player2.move("6");
        player1.move("7");
        Player winner = table.winner();

        assertThat(table.isWon()).isTrue();
        assertThat(winner).isEqualTo(player1);
    }
}
