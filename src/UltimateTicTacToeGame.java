public class UltimateTicTacToeGame {
    private String[][] board;
    //private String[][] correspondingBox;
    private boolean placeAnywhere;

    public UltimateTicTacToeGame() {
        board = new String[9][9];
        placeAnywhere = true;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setPlaceAnywhere(boolean placeAnywhere) {
        this.placeAnywhere = placeAnywhere;
    }
    //Resolve?

    public boolean canPlaceAnywhere() {
        return placeAnywhere;
    }
    public String[][] getBox(int row, int column) {
        String[][] box = new String[3][3];
        int c;
        if (column == 3) {
            c = 7;
        } else if (column == 2) {
            c = 3;
        } else {
            c = 0;
        }
        for (int i = 1; i <= 3; i ++) {
            for (int j = 0; j <= 2; j ++) {
                //box[i][j] =  board[i * row][j + (column * 2)];
                System.out.print(board[i * row][j + (c) -1] + " ");
            }
        }
        return box;
    }



    public String toString() {
        String result = "";
        int count = 0;
        for (int i = 0; i < board.length; i ++) {

            if (i % 3 == 0 && i != 0) {
                result += "\n";
                for (int j = 0; j < 53; j ++) {
                    result += "█";
                }
            }
            else if (i % 1 == 0 && i != 0) {
                result += "\n";
                for (int j = 0; j < 54; j ++) {
                    if (j % 18 == 0 && j != 0) {
                        result += "█";
                    } else {
                        if (j != 0) {
                            result += "─";
                        }
                    }
                }
            }

            for (int j = 0; j < board.length; j ++) {

                if (j % 9 == 0) {
                    result += "\n";
                }
                else if (j % 3 == 0) {
                    result += " █";
                }
                else if (j % 1 == 0) {
                    result += " |";
                }
                //result += " ";
                result += " ";
                if (board[i][j] != null) {
                    result += board[i][j];
                } else {
                    result += "   ";
                }
            }
        }
        return result;
    }


}
