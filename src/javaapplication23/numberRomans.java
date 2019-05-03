/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;
import java.util.Scanner;
/**
 *
 * @author: Luis Alberto Guardia Calcina
 */
public class numberRomans {    
    int arrayValues[] = {1, 5, 10, 50, 100, 500, 1000};
    char characters[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private boolean evaluateNumberRoman(String romanNumber){
        boolean numberValid = true;
        for(int i = 0; i < romanNumber.length(); i++){
            char letter = romanNumber.charAt(i);
            if(!isValid(letter)){
                return false;
            }
        }
        return numberValid;
    }
    
    public int convertToInt(String romanNumber){
        String numbRoman = romanNumber.toUpperCase();
        int value = 0;
        char letter, next;
        int countEquals = 0;
        boolean sigIsMajor = false;
        if(evaluateNumberRoman(numbRoman)){
            for(int i = 0; i < numbRoman.length(); i++){
                if(i == numbRoman.length() - 1){
                    letter = numbRoman.charAt(i);
                    int actual = position(letter);
                    value += arrayValues[actual];                
                }else{
                    letter = numbRoman.charAt(i);
                    next = numbRoman.charAt(i + 1);
                    int actual = position(letter);
                    int sig = position(next);
                    if(arrayValues[actual] < arrayValues[sig]){
                        if(sigIsMajor){                        
                            System.out.println("Number Invalid");
                            return 0;
                        }else{
                            value -= arrayValues[actual]; 
                            sigIsMajor = true;
                            countEquals = 0;
                        }
                    }else{
                        if(arrayValues[actual] > arrayValues[sig]){
                            value += arrayValues[actual]; 
                            sigIsMajor = false;
                            countEquals = 0;
                        }else{
                            if(countEquals == 2 ){                    
                                System.out.println("Number Invalid");
                                return 0;
                            }else{
                                if(actual%2 == 0){
                                    value += arrayValues[actual]; 
                                    countEquals++;
                                }else{       
                                    System.out.println("Number Invalid");
                                    return 0;
                                }
                            }                      
                        }
                
                    }
                }         
            }
            return value;
        }else{
            System.out.println("Number Invalid");
            return 0;
        }
    }
    
    private boolean isValid(char letter){
        boolean isValid = false;
        for(int i = 0; i < characters.length; i++){
            if(letter == characters[i]){
                isValid = true;
            }
        }
        return isValid;
    }
    private int position(char letter){
        int positionCharacter = -1;
        for(int i = 0; i < characters.length; i++){
            if(letter == characters[i]){
                positionCharacter = i;
            }
        }
        return positionCharacter;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        numberRomans n = new numberRomans();
        System.out.print("Enter a Roman Number: ");
        String roman = read.nextLine();
        int value = n.convertToInt(roman);
        System.out.println("Val: " + value);
    }   
}
