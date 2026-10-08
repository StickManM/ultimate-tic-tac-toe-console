import java.util.Scanner;

public class UltimateTicTacToe
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        Scanner input = new Scanner(System.in);
        UltimateTicTacToeGame game = new UltimateTicTacToeGame();
        System.out.println(game);
        while (true) {
            try {
                System.out.println("Input X's spot (row column):");
                String spot = input.nextLine();
                char[] spotArr = spot.toCharArray();
                if (game.canPlaceAnywhere()) {
                    //game.setPlaceAnywhere(false);
                    String[][] gameArr = game.getBoard();
                    if (gameArr[(spotArr[0] - '0') -1][(spotArr[2] - '0') -1] != null) {
                        break;
                    }
                    gameArr[(spotArr[0] - '0') -1][(spotArr[2] - '0') -1] = " X ";
                    game.setBoard(gameArr);
                }
                System.out.println(game);

                System.out.println("Input O's spot (row column):");
                spot = input.nextLine();
                spotArr = spot.toCharArray();
                if (game.canPlaceAnywhere()) {
                    //game.setPlaceAnywhere(false);
                    String[][] gameArr = game.getBoard();
                    if (gameArr[(spotArr[0] - '0') -1][(spotArr[2] - '0') -1] != null) {
                        break;
                    }
                    gameArr[(spotArr[0] - '0') -1][(spotArr[2] - '0') -1] = " O ";
                    game.setBoard(gameArr);
                }
                System.out.println(game);
                game.getBox(1, 3);
            }
            catch (Exception ArrayIndexOutOfBoundsException) {
                System.out.println("ERROR: IMPROPER ROW COLUMN");
            }

            finally {
                //break;
            }

        }
    }
}