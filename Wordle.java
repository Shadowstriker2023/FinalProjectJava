import java.io.*;
import java.util.*;

public class Wordle {
    public static void main(String[] args) throws IOException {

        ArrayList<String> words = new ArrayList<>();
        Scanner file = new Scanner(new File("words.txt"));

        while (file.hasNext()) {
            String word = file.next().toLowerCase();
            if (word.length() == 5) {
                words.add(word);
            }
        }
        file.close();

        Random random = new Random();
        String target = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess the 5 letter word!");
        System.out.println("X means correct letter in correct position");
        System.out.println("* means correct letter in wrong position");
        System.out.println("+ means incorrect letter");

        for (int i = 1; i <= 6; i++) {
            System.out.print("Guess " + i + ": ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(target)) {
                System.out.println("You win!");
                return;
            }

            for (int j = 0; j < 5; j++) {
                if (guess.charAt(j) == target.charAt(j)) {
                    System.out.print("X");
                } else if (target.contains("" + guess.charAt(j))) {
                    System.out.print("*");
                } else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }

        System.out.println("You lost! The word was: " + target);
        scanner.close();
    }
}
