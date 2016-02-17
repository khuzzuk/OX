package Tests;

import OX.Player;
import static org.assertj.core.api.Assertions.*;
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
}
