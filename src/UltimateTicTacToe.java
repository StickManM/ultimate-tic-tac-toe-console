import java.util.Scanner;

public class UltimateTicTacToe
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        Scanner input = new Scanner(System.in);
        UltimateTicTacToeGame game = new UltimateTicTacToeGame();
        System.out.println(game);
        char[] lastSpotArr = {0};
        int validBox;
        while (true) {
            try {
                String spot;
                char[] spotArr;
                while (true) {
                    System.out.println("Input X's spot (row column):");
                    spot = input.nextLine();
                    spotArr = spot.toCharArray();
                    if (game.canPlaceAnywhere()) {
                        //game.setPlaceAnywhere(false);
                        String[][] gameArr = game.getBoard();
                        if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                            continue;
                        }
                        gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " X ";
                        game.setBoard(gameArr);
                        break;
                    } else {
                        validBox = game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'));
                        if (game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0')) != validBox) {
                            System.out.println("INVALID SPOT: MUST BE IN BOX NUMBER " + validBox);
                        } else {
                            System.out.println("VALID SPOT: IS IN BOX NUMBER " + validBox);
                            String[][] gameArr = game.getBoard();
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                continue;
                            }
                            gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " O ";
                            game.setBoard(gameArr);
                            break;
                        }
                    }
                }

                game.setPlaceAnywhere(false);
                lastSpotArr = spotArr;
                System.out.println(game);
                System.out.println(game.getValidBox(lastSpotArr));

                while (true) {
                    System.out.println("Input O's spot (row column):");
                    spot = input.nextLine();
                    spotArr = spot.toCharArray();
                    if (game.canPlaceAnywhere()) {
                        //game.setPlaceAnywhere(false);
                        String[][] gameArr = game.getBoard();
                        if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                            continue;
                        }
                        gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " O ";
                        game.setBoard(gameArr);
                        break;
                    } else {
                        validBox = game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'));
                        if (game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0')) != validBox) {
                            System.out.println("INVALID SPOT: MUST BE IN BOX NUMBER " + validBox);
                        } else {
                            System.out.println("VALID SPOT: IS IN BOX NUMBER " + validBox);
                            String[][] gameArr = game.getBoard();
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                continue;
                            }
                            gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " O ";
                            game.setBoard(gameArr);
                            break;
                        }
                    }
                }

                game.setPlaceAnywhere(false);
                lastSpotArr = spotArr;
                System.out.println(game);
                System.out.println(game.getValidBox(lastSpotArr));
                //game.getBox(1, 3);
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