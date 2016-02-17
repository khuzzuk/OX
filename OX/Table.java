package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Table {

    public static final int X_MARK = 1;
    public static final int O_MARK = -1;
    private static int[] table = new int[9];

    public static void mark(int field, int MARK){
        table[field-1]=MARK;
    }

    public static int field(int fieldNumber) {
        return table[fieldNumber-1];
    }
}
