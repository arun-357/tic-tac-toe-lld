import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter board size (N for NxN board): ");
        int size = scanner.nextInt();

        Player p1 = new Player("A", 'X');
        Player p2 = new Player("B", 'O');

        Game game = new Game(size, p1, p2);
        game.start();
    }
}
