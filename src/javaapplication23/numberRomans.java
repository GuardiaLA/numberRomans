package javaapplication23;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author: Luis Alberto Guardia Calcina
 */
public class numberRomans {    
    int arrayValues[] = {1, 5, 10, 50, 100, 500, 1000};
    char characters[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    ArrayList<Character> numbRomans = new ArrayList<Character>();
    ArrayList<Integer> integers = new ArrayList<Integer>();
        
    private boolean evaluateNumberRoman(String romanNumber){
        boolean numberValid = true;
        int positionLetter;
        numbRomans.clear();
        for (int i = 0; i < romanNumber.length(); i++) {
            char letter = romanNumber.charAt(i);
            positionLetter = position(letter);
            if ( positionLetter == -1) {
                return false;
            } else {
                if (positionLetter %2 != 0) {
                    if(verifyDuplicates(letter)) {
                        return false;
                    } else {
                        numbRomans.add(letter);
                    }
                } else {
                    numbRomans.add(letter);
                }
            }
        }
        return numberValid;
    }
    
    private int position(char letter){
        int positionCharacter = -1;
        for(int i = 0; i < characters.length; i++) {
            if(letter == characters[i]) {
                positionCharacter = i;
            }
        }
        return positionCharacter;
    }
    
    public boolean verifyDuplicates(char letter) {
        boolean exisDuplicate = false;
        if(numbRomans.size() == 0) {
            numbRomans.add(letter);
        } else {
            for(int i = 0; i<numbRomans.size(); i++) {
                if(numbRomans.get(i) == letter) {
                    exisDuplicate = true;
                }    
            }
        }
        return exisDuplicate;      
    }
    
    public int convertToInt(String romanNumber) {
        String numbRoman = romanNumber.toUpperCase();
        int value = 0;
        char letter, next, prev;
        int countEquals = 0;
        boolean nextIsMajor = false;
        if(evaluateNumberRoman(numbRoman)) {
            numbRomans.clear();
            for(int i = 0; i < numbRoman.length(); i++) {
                if(i == numbRoman.length() - 1) {
                    letter = numbRoman.charAt(i);
                    if(verifyDuplicates(letter)) {
                        System.out.println("Number Invalid");
                        return 0;
                    } else {
                        int actual = position(letter);
                        value += arrayValues[actual];                
                    }
                } else {
                    letter = numbRoman.charAt(i);
                    next = numbRoman.charAt(i + 1);
                    int actual = position(letter);
                    int nextPosition = position(next);
                    if(arrayValues[actual] < arrayValues[nextPosition]) {
                        if(verifyDuplicates(letter) || nextIsMajor || countEquals>0 ) {                        
                            System.out.println("Number Invalid");
                            return 0;
                        } else {
                            value -= arrayValues[actual];
                            numbRomans.add(letter);
                            nextIsMajor = true;
                            countEquals = 0;
                        }
                    } else {
                        if(arrayValues[actual] > arrayValues[nextPosition]) {
                            value += arrayValues[actual]; 
                            nextIsMajor = false;
                            countEquals = 0;
                        } else {
                            if(countEquals == 2 ) {                    
                                System.out.println("Number Invalid");
                                return 0;
                            } else {
                                if(actual%2 == 0) {
                                    value += arrayValues[actual]; 
                                    countEquals++;
                                } else {       
                                    System.out.println("Number Invalid");
                                    return 0;
                                }
                            }                      
                        }
                    }
                }         
            }
            return value;
        } else {
            System.out.println("Number Invalid");
            return 0;
        }
    }
    
    public static void main(String[] args) {
        numberRomans r = new numberRomans();
        System.out.println(r.convertToInt("0"));
        System.out.println(r.convertToInt(""));
        System.out.println(r.convertToInt("??"));
        System.out.println(r.convertToInt("12"));
        System.out.println(r.convertToInt("CC"));
        System.out.println(r.convertToInt("MM"));
        System.out.println(r.convertToInt("XXXIV"));
    }   
}
