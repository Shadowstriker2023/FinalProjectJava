import java.io.*;
import java.util.*;

public class Wordle{}

    public static void main(String[] args) throws IOException {
        List<String> words = loadWords("words.txt");
        if (words.isEmpty()) {
            System.out.println("Error: No valid words found in words.txt");
            return;
        }
