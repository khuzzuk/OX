package Tests;

import OX.Player;
import static org.assertj.core.api.Assertions.*;

import OX.Table;
import org.testng.annotations.Test;

/**
 * Created by adrabik on 17.02.16.
 */
public class OX_OOP_Tests {
    @Test
    public static void playerChooseXMark(){
        //given
        Player player = new Player();
        player.chooseX();
        String expected = "X";
        //when
        String mark = player.yourMark();
        //then
        assertThat(mark).isEqualTo(expected);
    }
    @Test
    public static void playerChooseOMark(){
        //given
        Player player = new Player();
        player.chooseO();
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
            player = Player.playerSelection(wrongChoice);
            mark = player.yourMark();
        }catch (Exception e) { assertThatExceptionOfType(IllegalArgumentException.class); }
        //then
        assertThat(mark).isNull();
    }

    @Test
    public static void playerOneMakesMove(){
        //given
        int fieldNumber = 1;
        //when
        Table.mark(fieldNumber, Table.X_MARK);
        //then
        assertThat(Table.field(fieldNumber)).isEqualTo(Table.X_MARK);
    }
    @Test
    public static void playerTwoMakesMove(){
        //given
        int fieldNumber = 1;
        //when
        Table.mark(fieldNumber, Table.O_MARK);
        //then
        assertThat(Table.field(fieldNumber)).isEqualTo(Table.O_MARK);
    }
}
