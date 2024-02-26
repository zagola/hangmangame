import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    List<String> words = List.of("car", "elephant", "programming", "aurora");
    String word;
    char[] userWord;
    int lives = 3;


    public void play () {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');
        System.out.println(userWord);

        while(!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Enter the next letter ");
            System.out.println("Left to live: " + lives);


            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);


        }

        if(lives == 0) {
            System.out.println("Unfortunately, you didn't win :(");
        }else {
            System.out.println("Well done, you managed to guess the word!");
        }

        scanner.close();

    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter= true;
            }
        }
        if(!foundLetter) {
            System.out.println("Unfortunately, there is no such letter :(");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));

    }

}
