package Tests;

import OX.Player;
import static org.assertj.core.api.Assertions.*;

import OX.Sign;
import OX.Table;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by adrabik on 17.02.16.
 */
public class OX_OOP_Tests {
    private static Table table;
    @BeforeMethod
    public static void clearTable(){
        table = new Table();
    }
    @Test
    public static void playerChooseXMark(){
        //given
        Player player = Player.playerSelection(Player.X_SIGN, table);
        String expected = "X";
        //when
        String mark = player.yourMark();
        //then
        assertThat(mark).isEqualTo(expected);
    }
    @Test
    public static void playerChooseOMark(){
        //given
        Player player = Player.playerSelection(Player.O_SIGN, table);

        String expected = "O";
        //when
        String mark = player.yourMark();
        //then
        assertThat(mark).isEqualTo(expected);
    }
    @Test
    public static void playerChooseWrongMark(){
        //given
        String wrongChoice = "1";
        Player player;
        String mark = null;
        //when
        try {
            player = Player.playerSelection(wrongChoice, table);
            mark = player.yourMark();
        }catch (Exception e) { assertThatExceptionOfType(IllegalArgumentException.class); }
        //then
        assertThat(mark).isNull();
    }
    @Test
    public static void playerChooseOccupiedField(){
        //given
        int field = 1;
        Sign choice1 = Table.X_MARK;
        Sign choice2 = Table.O_MARK;
        //when
        table.mark(field,choice1);
        table.mark(field,choice2);
        //then
        assertThat(table.field(field)).isEqualTo(choice1);
    }
    @Test
    public static void playerChooseWrongField(){
        //given
        String field = "field";
        Player player = Player.playerSelection(Player.X_SIGN, table);
        //when
        try {
            player.move(field);
            player = null;
        }catch (Exception e) { assertThatExceptionOfType(IllegalArgumentException.class); }
        //then
        assertThat(player).isNotNull();
    }

    @Test
    public static void playerOneMakesMove(){
        //given
        int fieldNumber = 1;
        //when
        table.mark(fieldNumber, Table.X_MARK);
        //then
        assertThat(table.field(fieldNumber)).isEqualTo(Table.X_MARK);
    }
    @Test
    public static void playerTwoMakesMove(){
        //given
        int fieldNumber = 1;
        //when
        table.mark(fieldNumber, Table.O_MARK);
        //then
        assertThat(table.field(fieldNumber)).isEqualTo(Table.O_MARK);
    }
}
