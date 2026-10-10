import java.util.Scanner;

public class UltimateTicTacToe
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        Scanner input = new Scanner(System.in);
        UltimateTicTacToeGame game = new UltimateTicTacToeGame();
        System.out.println(game);
        char[] lastSpotArr = {0, 0, 0};
        int validBox = 0;
        boolean firstTurn = true;
        boolean turn = true;
        while (true) {
            try {
                String spot;
                char[] spotArr;

                if (turn) {
                    while (true) {
                        System.out.println("Input X's spot (row column):");
                        spot = input.nextLine();
                        spotArr = spot.toCharArray();

                        if (!firstTurn) {
                            validBox = game.getValidBox(lastSpotArr);

                            if (game.checkBoxFull(validBox)) {
                                game.setPlaceAnywhere(true);
                            }
                        }

                        if (spotArr[1] == '-') {
                            game.setPlaceAnywhere(true);

                        }

                        if (game.canPlaceAnywhere()) {
                            String[][] gameArr = game.getBoard();
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                System.out.println("INVALID MOVE: THAT SPOT IS TAKEN");
                                continue;
                            }
                            gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " X ";
                            game.setBoard(gameArr);
                            break;
                        } else {

                            if (game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0')) != validBox) {
                                System.out.println("INVALID SPOT: MUST BE IN BOX NUMBER " + validBox);
                            } else {
                                System.out.println("VALID BOX: IS IN BOX NUMBER " + validBox);
                                String[][] gameArr = game.getBoard();
                                if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                    System.out.println("INVALID MOVE: THAT SPOT IS TAKEN");
                                    continue;
                                }
                                gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " X ";
                                game.setBoard(gameArr);
                                break;
                            }
                        }
                    }


                    game.setPlaceAnywhere(false);
                    lastSpotArr[0] = spotArr[0];
                    lastSpotArr[1] = ' ';
                    lastSpotArr[2] = spotArr[2];
                    System.out.println(game);
                    firstTurn = false;
                    turn = false;
                }

                if (!turn) {
                    while (true) {
                        System.out.println("Input O's spot (row column):");
                        spot = input.nextLine();
                        spotArr = spot.toCharArray();


                        validBox = game.getValidBox(lastSpotArr);

                        if (game.checkBoxFull(validBox)) {
                            game.setPlaceAnywhere(true);
                        }

                        if (spotArr[1] == '-') {
                            game.setPlaceAnywhere(true);

                        }

                        if (game.canPlaceAnywhere()) {
                            //game.setPlaceAnywhere(false);
                            String[][] gameArr = game.getBoard();
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                System.out.println("INVALID MOVE: THAT SPOT IS TAKEN");
                                continue;
                            }
                            gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " O ";
                            game.setBoard(gameArr);
                            break;
                        } else {
                            if (game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0')) != validBox) {
                                System.out.println("INVALID SPOT: MUST BE IN BOX NUMBER " + validBox);
                            } else {
                                System.out.println("VALID BOX: IS IN BOX NUMBER " + validBox);
                                String[][] gameArr = game.getBoard();
                                if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null) {
                                    System.out.println("INVALID MOVE: THAT SPOT IS TAKEN");
                                    continue;
                                }
                                gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] = " O ";
                                game.setBoard(gameArr);
                                break;
                            }
                        }
                    }

                    game.setPlaceAnywhere(false);
                    lastSpotArr[0] = spotArr[0];
                    lastSpotArr[1] = ' ';
                    lastSpotArr[2] = spotArr[2];
                    System.out.println(game);
                    turn = true;

                }
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