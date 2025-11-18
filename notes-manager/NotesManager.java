import java.io.*;
import java.util.*;

public class NotesManager {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("1.Add 2.View 3.Exit → ");
            int c = s.nextInt(); s.nextLine();

            if (c == 1) {
                System.out.print("Note: ");
                String note = s.nextLine();
                FileWriter fw = new FileWriter("notes.txt", true);
                fw.write(note + "\n");
                fw.close();
            }

            else if (c == 2) {
                BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println("- " + line);
                br.close();
            }

            else break;
        }
    }
}
