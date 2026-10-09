public class UltimateTicTacToeGame {
    private String[][] board;
    //private String[][] correspondingBox;
    private boolean placeAnywhere;
    //private int[][][] boxArr;
   // private String[][] box1Arr = new String[3][3];

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
    /*public String[][] getBox(int row, int column) {
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
                //System.out.print(board[i * row][j + (c) -1] + " ");
            }
        }
        return box;
    }*/

    public int getValidBox(char[] move) {
        String strmove = new String(move);
        for (int h = 1; h <= 9; h++) {
            String[][] box = generateBoxArray(h);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (box[i][j].equals(strmove)) {
                        //System.out.println(box[i][j]);
                        return (i * 3) + j + 1;

                    }
                }
            }
        }
        return 0;
    }

    public static String[][] generateBoxArray(int boxNum) {
        String[][] boxArr = new String[3][3];


        int rowOffset = ((boxNum-1)/3) *3;
        int columnOffset = ((boxNum-1)%3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxArr[i][j] = (1+rowOffset+i) + " " + (1+columnOffset+j);
                //System.out.println(boxArr[i][j]);
            }
        }

        return boxArr;

    }

    public int getBoxNum(int row, int column) {

        if (row == 1 || row == 2 || row == 3) {
            if (column == 1 || column == 2 || column == 3) {
                return 1;
            } else if (column == 4 || column == 5 || column == 6) {
                return 2;
            } else if (column == 7 || column == 8 || column == 9) {
                return 3;
            }
        } else if (row == 4 || row == 5 || row == 6) {
            if (column == 1 || column == 2 || column == 3) {
                return 4;
            } else if (column == 4 || column == 5 || column == 6) {
                return 5;
            } else if (column == 7 || column == 8 || column == 9) {
                return 6;
            }
        } else if (row == 7 || row == 8 || row == 9) {
            if (column == 1 || column == 2 || column == 3) {
                return 7;
            } else if (column == 4 || column == 5 || column == 6) {
                return 8;
            } else if (column == 7 || column == 8 || column == 9) {
                return 9;
            }
        }

        return 0;
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
