public class Player {
    String name;
    int hp = 100;

    Player(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println(name + " attacks!");
    }
}
