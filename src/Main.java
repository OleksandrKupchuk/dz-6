import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static HashMap<String, Integer> mapCountSymbols = new HashMap<>();
    private static List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        String[] data = new String[]{"tata", "uutd", "yaya", "test"};

        System.out.println("unique letters = " + findFirstTwoWordsThatConsistOfEvenLettersAndReturnLettersOfTheseWords(data));
    }

    public static HashMap findFirstTwoWordsThatConsistOfEvenLettersAndReturnLettersOfTheseWords(String[] array) {
        for (String word : array) {
            if (words.size() == 2) {
                System.out.println("Two words already found it is " + words);
                return calculationUniqueSymbols(words);
            }
            if (word.length() % 2 == 0) {
                checkingWhetherWordConsistsEntirelyOfEvenLetters(word);
            } else {
                System.out.println("Two words consisting of an even number of letters were not found");
            }
        }

        return calculationUniqueSymbols(words);
    }

    public static void checkingWhetherWordConsistsEntirelyOfEvenLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            countHowManyTimesGivenLetterOccursInWordAndWriteDownInHashMap(word, word.charAt(i));
        }

        keyValueParityCheckForWord(word);

        mapCountSymbols.clear();
    }

    public static void countHowManyTimesGivenLetterOccursInWordAndWriteDownInHashMap(String word, char symbol) {
        String stringSymbol = String.valueOf(symbol);
        if (mapCountSymbols.containsKey(stringSymbol)) {
            System.out.println(String.format("Symbol '%s' is exist in HasMap for '%s'", symbol, word));
            return;
        }

        int countChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (symbol == word.charAt(i)) {
                countChar += 1;
            }
        }
        mapCountSymbols.put(stringSymbol, countChar);
    }

    public static void keyValueParityCheckForWord(String word) {
        for (int i = 0; i < mapCountSymbols.keySet().size(); i++) {
            Object key = mapCountSymbols.keySet().toArray()[i];
            if (mapCountSymbols.get(key) % 2 != 0) {
                mapCountSymbols.clear();
                System.out.println(String.format("'%s' not have does not contain all letters an even number of times", word));
                return;
            }
            if (i == mapCountSymbols.keySet().size() - 1) {
                words.add(word);
            }
        }
    }

    public static HashMap calculationUniqueSymbols(List<String> array) {
        HashMap<String, Integer> mapUniqueSymbols = new HashMap<>();
        String longWord = "";
        for (String word : array) {
            longWord += "" + word;
        }

        for (int i = 0; i < longWord.length(); i++) {
            String stringSymbol = String.valueOf(longWord.charAt(i));
            if (!mapUniqueSymbols.containsKey(stringSymbol)) {
                mapUniqueSymbols.put(stringSymbol, i);
            }
        }
        return mapUniqueSymbols;
    }
}