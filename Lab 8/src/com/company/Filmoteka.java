package com.company;

import java.io.*;
import java.util.ArrayList;

public class Filmoteka {
    private ArrayList<Film> films;

    public Filmoteka(ArrayList<Film> list) {
        films = list;
    }
    public void printList(){
        for(Film film : films){
            System.out.println(film);
        }
    }

    public void printList(boolean isAvailable) {
        for (Film film : films) {
            if (film.isAvailable() == isAvailable)
                System.out.println(film);
        }
    }

    public String findFilmByActor(String actor) {
        String result = "";
        for (Film film : films){
            if (film.getActor().contains(actor))
                result += film.toString();
        }           return result.isEmpty()?"нічого не знайдено":result;
    }
    public void saveToFile(String fileName){
        File file = new File(fileName);
        try {
            FileOutputStream fileOut =  new FileOutputStream(file);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            for(Film book: films){
                outStream.writeObject(book);
            }
            outStream.close();
        }
        catch (FileNotFoundException e) {
            // методи запису у файл вимагають обробки винятків
            System.out.println("Файл для запису даних не створено - " +   e.getMessage() );
        }
        catch (IOException e) {
            System.out.println("Помилка запису даних - " + e.getMessage() );
        }
    }

    public void loadFromFile(String fileName){
        File file = new File(fileName);
        int i = 0;
        Film film=null;
        ObjectInputStream inStream = null;
        try {
            FileInputStream fileIn =  new FileInputStream(file);
            inStream = new ObjectInputStream(fileIn);
            if(inStream != null){
                while(true){
                    film = (Film) inStream.readObject();
                    if(film==null)break;
                    // books[i++] = book;
                    films.add(film);
                    //читання даних з файлу в масив
                }
                inStream.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Не знайдено файл з даними - " + e.getMessage() );
        }
        catch (ClassNotFoundException e) {
            System.out.println("Помилка в структурі даних - " + e.getMessage() );
        }
        catch (IOException e) {
            System.out.println("Помилка читання даних - " + e.getMessage() );
        }
    }
}
