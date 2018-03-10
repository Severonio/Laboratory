package com.company;
//Дано рядок зі слів, розділених пробілами. Вивести на екран всі слова-
//паліндроми. Якщо таких слів немає, видати відповідне повідомлення.
import java.lang.String;

public class Main2 {
    public static void main(String[] args) {
        String str = "What is this level repaper stats";
        boolean isReverveWordExist = true;

        for (String retval : str.split(" ")) {

            StringBuilder stringBuilder = new StringBuilder(retval);
            StringBuilder stringBuilderReverse = stringBuilder.reverse();
            String reverseString = stringBuilderReverse.toString();

            if (retval.equals(reverseString)) {
                System.out.println("Полиндром: " + retval);
                isReverveWordExist = false;
            }
        }

        if (isReverveWordExist) {
            System.out.println("Не найдено полиндромов");
        }
    }
}
