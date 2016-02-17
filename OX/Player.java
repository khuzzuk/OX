package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Player {
    private String mark;

    public void chooseX() {
        mark = "X";
    }

    public void chooseO() {
        mark = "O";
    }

    public String yourMark() {
        return mark;
    }
}
