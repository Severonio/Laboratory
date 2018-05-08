package com.company;

import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Main  {

    public static void main(String[] args) throws ParseException, IOException {
        Filmoteka myFilmoteka;
        ArrayList<Film> films = new ArrayList<>();
        /*Film [] films = {new Film("Lord of the Rings", 2001, "Elijah Wood, Ian McKellen, Liv Tyler", ".avi", 2500, "free" ),
                new Film("Iron Man", 2008, "Robert Downey Jr., Gwyneth Paltrow, Jeff Bridges", ".mp4", 4000, "not free"),
                new Film("Black Panther", 2018, "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o", ".mp4", 3000, "free")};*/
        films.add(new Film("Lord of the Rings", 2001, "Elijah Wood, Ian McKellen, Liv Tyler", ".avi", 2500, "free" ));
        films.add(new Film("Iron Man", 2008, "Robert Downey Jr., Gwyneth Paltrow, Jeff Bridges", ".mp4", 4000, "not free"));
        films.add(new Film("Black Panther", 2018, "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o", ".mp4", 3000, "free"));
        myFilmoteka = new Filmoteka(films);

        /*System.out.println("Films: ");
        myFilmoteka.printList();
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
        System.out.print("Actor(s): ");
        String actor = input.readLine();
        String filmsactor = myFilmoteka.findFilmByActor(actor);
        System.out.println(filmsactor);*/

        String fileName = "d:\\symbol.txt";
        myFilmoteka.saveToFile(fileName);
        ArrayList<Film> booksFromFile = new ArrayList<>();
        Filmoteka myLibraryFromFile = new Filmoteka(booksFromFile);
        myLibraryFromFile.loadFromFile(fileName);
        System.out.println("Список книг у бібліотеці (з файлу):");
        myLibraryFromFile.printList();

    }
}

