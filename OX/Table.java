package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Table {

    public static final int X_MARK = 1;
    public static final int O_MARK = -1;
    private int[] table;
    {
        table = new int[9];
    }

    public Table(){
        for (int x = 0; x < table.length; x++) {
            table[x]=0;
        }
    }
    public void mark(int field, int MARK){
        if (table[field-1]==0) table[field-1]=MARK;
        else System.out.println("Field is already occupied.");
    }

    public int field(int fieldNumber) {
        return table[fieldNumber-1];
    }

    public void newGame() {
        for (int x = 0; x < table.length; x++) {
            table[x]=0;
        }
    }
}
