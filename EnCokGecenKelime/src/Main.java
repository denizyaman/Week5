import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String maxWord=" ";
        int maxWordCount=0;
        Scanner inp = new Scanner(System.in);
        System.out.println("Metni giriniz:");
        String enteredWord = inp.nextLine();
        //Boşluğa göre kelimeleri ayırırız.
        String[] splittedArray = enteredWord.split(" ");
        Map<String, Integer> wordCounter = new HashMap<>();
        //Tüm diziyi dönerek kelimeleri gezeriz.
        for (String word : splittedArray) {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else
                wordCounter.put(word, 1);
        }

        for(Map.Entry<String, Integer> wordCount : wordCounter.entrySet()) {
           if(wordCount.getValue()>maxWordCount){
               maxWordCount=wordCount.getValue();
               maxWord=wordCount.getKey();
           }

        }
        System.out.println("En çok tekrar eden kelime: "+ maxWord +" "+maxWordCount+" kez tekrar ediyor.");
    }
}