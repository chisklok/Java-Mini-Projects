import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Name: ");
        Player p = new Player(s.nextLine());

        System.out.println("Welcome " + p.name + "! A monster appears.");

        while (p.hp > 0) {
            System.out.print("[1]Attack [2]Run → ");
            int c = s.nextInt();

            if (c == 1) {
                p.attack();
                p.hp -= 10;
                System.out.println("HP: " + p.hp);
            } else break;
        }
    }
}
