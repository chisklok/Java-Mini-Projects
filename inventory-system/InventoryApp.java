import java.util.*;

public class InventoryApp {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("1.Add 2.List 3.Exit → ");
            int c = s.nextInt(); s.nextLine();

            if (c == 1) {
                System.out.print("Name: ");
                String n = s.nextLine();
                System.out.print("Qty: ");
                int q = s.nextInt();

                items.add(new Item(n, q));
            }

            else if (c == 2) {
                for (Item i : items)
                    System.out.println(i.name + " x" + i.qty);
            }

            else break;
        }
    }
}
