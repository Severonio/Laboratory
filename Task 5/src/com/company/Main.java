package com.company;
import com.sun.org.apache.xpath.internal.SourceTree;
//Дано рядок з декількох слів. Слова відокремлюються одне від одного
//пробілами або комами. Підрахувати кількість слів, довжина яких
//більше заданого числа.
import java.io.InputStreamReader;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int i;
        int counter = 0;
        int mainCounter = 0;

        String mainString = "The most direct way to create a string, is to write";
        int mainLen = mainString.length();

        System.out.print("Word: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String sideWord = input.readLine();
        int sideLen = sideWord.length();

        char[] mainArray = new char[mainLen];


        for(i = 0; i < mainLen; i++){
            mainArray[i] = mainString.charAt(i);
        }

        for(i = 0; i < mainLen; i++ ){//main loop
            counter++;
            System.out.println("conter = " + counter);
            if(mainArray[i] == ' ' || mainArray[i] == ','){
                counter--;//space/, counts too
                if(counter > sideLen){
                    mainCounter++;
                    System.out.println("Main = " + mainCounter);
                }
                counter = 0;
            }
        }
        System.out.println("Amount of words that bigger than - " + sideWord + " = " + mainCounter + ".");
    }
}
