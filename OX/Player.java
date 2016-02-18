package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Player {
    public static final String X_SIGN = "X";
    public static final String O_SIGN = "O";
    private String mark;
    private Table table;

    public void chooseX() {
        mark = X_SIGN;
    }

    public void chooseO() {
        mark = O_SIGN;
    }

    public String yourMark() {
        return mark;
    }

    public void move(String field) {
        if (field.length()-field.replaceAll("[^1-9]","").length()>0 || field.length()>1) throw new IllegalArgumentException();
        if (mark.equals(X_SIGN))
            table.mark(Integer.parseInt(field), Table.X_MARK);
        else table.mark(Integer.parseInt(field), Table.O_MARK);
    }

    public static Player playerSelection(String choice, Table table) throws IllegalArgumentException {
        Player player = new Player();
        if (choice.equals(X_SIGN)) player.chooseX();
        else if (choice.equals(O_SIGN)) player.chooseO();
        else throw new IllegalArgumentException("Wrong choice");
        player.table = table;
        return player;
    }
}
