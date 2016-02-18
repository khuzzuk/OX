package OX;

/**
 * Created by adrabik on 17.02.16.
 */
public class Table {

    public static final Sign X_MARK = Sign.X;
    public static final Sign O_MARK = Sign.O;

    private Player winner;
    private Player playerX;
    private Player playerO;

    private Sign[] table;
    {
        table = new Sign[9];
    }

    public Table(){
        for (int x = 0; x < table.length; x++) {
            table[x]=Sign.empty;
        }
    }
    public void mark(int field, Sign mark){
        if (table[field-1]==Sign.empty) table[field-1]=mark;
        else System.out.println("Field is already occupied.");
    }

    public Sign field(int fieldNumber) {
        return table[fieldNumber-1];
    }

    public void newGame() {
        for (int x = 0; x < table.length; x++) {
            table[x]=Sign.empty;
        }
    }

    public void setPlayer(Player player){
        if (player.yourMark().equals(Player.X_SIGN)) playerX=player;
        else playerO=player;
    }

    public Player winner() {
        if (isWon())
            return winner;
        else return null;
    }
    public boolean isWon(){
        Sign[][] conditions = winningRows();
        int matchingInRow;
        Sign winnerMark=Sign.empty;
        for (int x = 0; x < conditions.length; x++) {
            matchingInRow=0;
            for (int y = 0; y < conditions[x].length-1; y++) {
                if (conditions[x][y]!=Sign.empty && conditions[x][y]==conditions[x][y+1]) {
                    matchingInRow++;
                    winnerMark = conditions[x][y];
                }
            }
            if (matchingInRow==2) {
                if (winnerMark==X_MARK)
                    winner= playerX;
                else winner=playerO;
                return true;
            }
        }
        return false;
    }
    private Sign[][] winningRows(){
        Sign[][] winningsConditions = new Sign[table.length-1][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                winningsConditions[x][y] = table[3*x+y];
                winningsConditions[x+3][y] = table[y*3+x];
            }
        }
        winningsConditions[6][0] = table[0];
        winningsConditions[6][1] = table[4];
        winningsConditions[6][2] = table[8];
        winningsConditions[7][0] = table[2];
        winningsConditions[7][1] = table[4];
        winningsConditions[7][2] = table[6];
        return winningsConditions;
    }
}
