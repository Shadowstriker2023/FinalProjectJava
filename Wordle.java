import java.io.*;
import java.util.*;

public class Wordle{

    public static void main(String[] args) throws IOException {
        List<String> words = loadWords("words.txt");
if (words.isEmpty()) {
            System.out.println("Error: No valid words found in words.txt");
            return;
        }

        Random random = new Random();
        String target = words.get(random.nextInt(words.size()));
        Scanner scanner = new Scanner(System.in);
        int maxGuesses = 6;
        boolean won = false;

        System.out.println("=== WORDLE ===");
        System.out.println("Guess the 5-letter word. You have " + maxGuesses + " attempts.");
        System.out.println("X = correct letter & position");
        System.out.println("* = correct letter, wrong position");
        System.out.println("+ = letter not in word");
        System.out.println();
    }
}

