package OX;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by adrabik on 18.02.16.
 */
public class main {
    public static Table table;
    public static void clearTable(){
        table = new Table();
    }
    public static void main(String[] args){
        clearTable();
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
