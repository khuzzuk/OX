package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Player {
    public static final String X_SIGN = "X";
    public static final String O_SIGN = "O";
    private String mark;

    public void chooseX() {
        mark = X_SIGN;
    }

    public void chooseO() {
        mark = O_SIGN;
    }

    public String yourMark() {
        return mark;
    }

    public void move(int field) {
        if (mark.equals(X_SIGN))
            Table.mark(field, Table.X_MARK);
        else Table.mark(field, Table.O_MARK);
    }
}
