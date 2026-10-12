import java.util.Scanner;

public class UltimateTicTacToe
{
    public static void main(String[] args)
    {
        //Introduction and rules
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        System.out.println();
        System.out.println("Here are the rules: ");
        System.out.println("Just like in regular tic-tac-toe, the two players (X and O) take turns. The game starts with either X or O playing wherever they want in any of the 81 empty spots. On each subsequent move, the players must play in the section of the larger board corresponding to the previous move's location within the smaller board it was played in.");
        System.out.println("If a move is played so that it wins a small board by the rules of normal tic-tac-toe, then the entire small board is marked as won by the player in the larger board. Once a small board is won by a player or it is filled completely, no more moves can be played in that board, and a player sent to that board may choose any other valid board to play in.");
        System.out.println("The game ends when either a player wins the larger board or there are no playable small boards remaining, in which case the game is a draw");

        //Initialization of Variables and Whatnot
        Scanner input = new Scanner(System.in);
        UltimateTicTacToeGame game = new UltimateTicTacToeGame();
        System.out.println(game);
        char[] lastSpotArr = {0, 0, 0};
        int validBox = 0;
        boolean firstTurn = true;
        boolean turn = true;

        //Main gameplay while loop
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
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null || game.isUnavailableBox((game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0'))))) {
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
                                if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null || game.isUnavailableBox((game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0'))))) {
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

                    if (game.isBoxWinner(" X ", (game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'))))) {
                        System.out.println("X HAS WON BOX NUMBER " + (game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'))));

                        if (game.isWinner(" X ")) {
                            System.out.println("X HAS WON THE GAME!");
                            break;
                        }
                    }

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
                            if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null || game.isUnavailableBox((game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0'))))) {
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
                                if (gameArr[(spotArr[0] - '0') - 1][(spotArr[2] - '0') - 1] != null || game.isUnavailableBox((game.getBoxNum((spotArr[0] - '0'), (spotArr[2] - '0'))))) {
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

                    if (game.isBoxWinner(" O ", (game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'))))) {
                        System.out.println("O HAS WON BOX NUMBER " + (game.getBoxNum((lastSpotArr[0] - '0'), (lastSpotArr[2] - '0'))));

                        if (game.isWinner(" O ")) {
                            System.out.println("O HAS WON THE GAME!");
                            break;
                        }
                    }


                }
            }
            catch (Exception e) {
                System.out.println("ERROR: IMPROPER ROW COLUMN");
                //e.printStackTrace();
            }

            finally {
                //break;
            }

        }
    }
}