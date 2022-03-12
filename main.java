/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg10;

import java.io.*;
import java.util.*;

/**
 *
 * @author Yisacor
 */
public class Lab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menue();
    }

    public static TreeMap<String, Integer> readFile(String file) {
        TreeMap<String, Integer> wordList = new TreeMap<>();
        List<String> listOfWords = new ArrayList<>();

        try {
            String words = file;
            Scanner s = new Scanner(new File(words));
            while (s.hasNextLine()) {
                //  String data = s.nextLine();

                listOfWords.add(s.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND");
        }
        
        Object[] listOfWord = listOfWords.toArray();
        for (Object listOfWord1 : listOfWord) {
            Integer c = wordList.get(listOfWord1);
            if (wordList.get((String) listOfWord1) == null) {
                wordList.put((String) listOfWord1, 1);
            }
            else {
                wordList.put((String) listOfWord1, ++c);
            }
        }
        return wordList;
    }

    /**
     *
     * @param wordList of type TreeMap
     */
    public static void search(TreeMap wordList) {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = myObj.nextLine();
        if (wordList.containsKey(word)) {
            int frequency = (int) wordList.get(word);
            System.out.println(word + "=>" + frequency);
        } else {
            System.out.println(word + "=>0");
        }
    }
    public static void display(TreeMap wordList) {
        Set<Map.Entry<Integer, String>> entrySet = wordList.entrySet();
        entrySet.forEach(currentEntry -> {
            System.out.println(currentEntry.getKey() + "=>" + (int) wordList.get(currentEntry.getKey()));
        });
    }

    public static void menue() {
        String file = "words.txt";
        TreeMap wordList = (readFile(file));
        int choice;
        boolean Quit = false;

        do {
            System.out.println("1. Search");
            System.out.println("2. Display");
            System.out.println("3. Quit");
            choice = CheckInput.getIntRange(1, 3);

            switch (choice) {
                case 1:                    
                    search(wordList);
                    break;

                case 2:
                    display(wordList );
                    break;
                case 3:
                    Quit = true;
                    break;
                default:
                    break;
            }
        } while (!Quit);

    }
}
