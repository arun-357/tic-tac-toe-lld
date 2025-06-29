import java.util.Scanner;

public class Game {
    private final Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus gameStatus;

    public Game(int boardSize, Player player1, Player player2) {
        this.board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (gameStatus == GameStatus.IN_PROGRESS) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn [" + currentPlayer.getSymbol() + "] — Enter row and column:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("❌ Invalid move. Try again.");
                continue;
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                gameStatus = GameStatus.WIN;
                board.printBoard();
                System.out.println("🏆 " + currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                gameStatus = GameStatus.DRAW;
                board.printBoard();
                System.out.println("🤝 It's a draw!");
                break;
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
        scanner.close();
    }
}
