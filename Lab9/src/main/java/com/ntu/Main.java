package com.ntu;

import com.ntu.dao.*;
import com.ntu.domain.Book;
import com.ntu.domain.BookRegister;
import com.ntu.domain.PersonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BookDAO bookDAO =  new BookDAOImpl();
        PersonReaderDAO personReaderDAO =  new PersonReaderDAOImpl();
        BookRegisterDAO bookRegisterDAO =  new BookRegisterDAOImpl();

        Scanner sc = new Scanner(System.in);
        BufferedReader sc1 = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1: додати книгу              8: змінити дані про читача");
            System.out.println("2: додати читача             9: повернули книгу");
            System.out.println("3: додати запис до реєстру   10: список книг");
            System.out.println("4: видалити книгу            11: список читачів");
            System.out.println("5: видалити читача           12: список записів у реєстрі");
            System.out.println("6: видалити запис в реєстрі  13: список неповернених книжок у реєстрі");
            System.out.println("7: змінити дані про книгу    14: список повернених книжок у реєстрі");

            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.print("Внесіть назву книги: ");
                    String title = sc.nextLine();
                    System.out.print("Внесіть автора книги: ");
                    String author = sc.nextLine();
                    System.out.print("Внесіть рік друку книги: ");
                    int printYear = sc.nextInt();
                    System.out.print("Внесіть кількість сторінок книги: ");
                    int countOfPages = sc.nextInt();

                    Book book = new Book(title, author, printYear, countOfPages );
                    bookDAO.insertBook(book);
                    break;
                case "2":
                    System.out.print("Внесіть імя читача: ");
                    String firstName = sc.nextLine();
                    System.out.print("Внесіть по-батькові читача: ");
                    String middleName = sc.nextLine();
                    System.out.print("Внесіть прізвище читача: ");
                    String lastName = sc.nextLine();
                    System.out.print("Внесіть телефон читача: ");
                    String phone = sc.nextLine();
                    System.out.print("Внесіть дату народження читача (yyyy-MM-dd): ");
                    String birthDt = sc.nextLine();
                    System.out.print("Внесіть адресу читача: ");
                    String address = sc.nextLine();
                    System.out.print("Внесіть серію паспорта: ");
                    String serialOfPassport = sc.nextLine();
                    System.out.print("Внесіть номер паспорта: ");
                    int numOfPassport = sc.nextInt();

                    Date birthDtIn = DateUtil.convertStringIntoSqlDate(birthDt);
                    PersonReader personReader = new PersonReader(firstName, middleName, lastName, phone, birthDtIn, serialOfPassport, numOfPassport, address );
                    personReaderDAO.insertPersonReader(personReader);
                    break;
                case "3":
                    System.out.print("Внесіть дату видачі (yyyy-MM-dd): ");
                    String vydanoDt = sc.nextLine();
                    System.out.print("Внесіть ID книги: ");
                    int bookId = sc.nextInt();
                    System.out.print("Внесіть ID читача: ");
                    int personReaderId = sc.nextInt();


                    Book bookFromDB = bookDAO.getBookById(bookId);
                    PersonReader personReaderFromDB = personReaderDAO.getPersonReaderById(personReaderId);

                    Date vydanoDtIn = DateUtil.convertStringIntoSqlDate(vydanoDt);
                    BookRegister bookRegister = new BookRegister(bookFromDB, vydanoDtIn, personReaderFromDB);
                    bookRegisterDAO.insertBookRegister(bookRegister);

                    break;
                case "4":
                    System.out.print("Внесіть ID книги: ");
                    int bookIdDel = sc.nextInt();
                    bookDAO.deleteBook(bookIdDel);

                    break;
                case "5":
                    System.out.print("Внесіть ID читача: ");
                    int personReaderIdDel = sc.nextInt();
                    personReaderDAO.deletePersonReader(personReaderIdDel);
                    break;
                case "6":
                    System.out.print("Внесіть ID запису реєстру: ");
                    int bookRegisterIdDel = sc.nextInt();
                    bookRegisterDAO.deleteBookRegister(bookRegisterIdDel);
                    break;
                case "7":
                    System.out.print("Внесіть ID: ");
                    long idUpdate = sc.nextLong();

                    System.out.print("Внесіть назву книги: ");
                    String titleUpdate = sc1.readLine();

                    System.out.print("Внесіть автора книги: ");
                    String authorUpdate = sc.nextLine();

                    System.out.print("Внесіть рік друку книги: ");
                    int printYearUpdate = sc.nextInt();

                    System.out.print("Внесіть кількість сторінок книги: ");
                    int countOfPagesUpdate = sc.nextInt();

                    Book bookUpdate = new Book(idUpdate, titleUpdate, authorUpdate, printYearUpdate, countOfPagesUpdate);
                    bookDAO.updateBook(bookUpdate);
                    break;
                case "8":
                    System.out.println("Внесіть ID: ");
                    long idUpdateN = sc.nextLong();
                    System.out.print("Внесіть імя читача: ");
                    String firstNameUpdate = sc.nextLine();
                    System.out.print("Внесіть по-батькові читача: ");
                    String middleNameUpdate = sc.nextLine();
                    System.out.print("Внесіть прізвище читача: ");
                    String lastNameUpdate = sc.nextLine();
                    System.out.print("Внесіть телефон читача: ");
                    String phoneUpdate = sc.nextLine();
                    System.out.print("Внесіть дату народження читача (yyyy-MM-dd): ");
                    String birthDtUpdate = sc.nextLine();
                    System.out.print("Внесіть адресу читача: ");
                    String addressUpdate = sc.nextLine();
                    System.out.print("Внесіть серію паспорта: ");
                    String serialOfPassportUpdate = sc.nextLine();
                    System.out.print("Внесіть номер паспорта: ");
                    int numOfPassportUpdate = sc.nextInt();

                    Date birthDtInUpdate = DateUtil.convertStringIntoSqlDate(birthDtUpdate);
                    PersonReader personReaderUpdate = new PersonReader(idUpdateN, firstNameUpdate, middleNameUpdate, lastNameUpdate,
                            phoneUpdate, birthDtInUpdate, serialOfPassportUpdate, numOfPassportUpdate, addressUpdate);
                    personReaderDAO.updatePersonReader(personReaderUpdate);
                    break;
                case "9":
                    System.out.print("Внесіть дату видачі (yyyy-MM-dd): ");
                    String vydanoData = sc.nextLine();
                    System.out.print("Внесіть ID книги: ");
                    int bookIdPoverneno = sc.nextInt();
                    System.out.print("Внесіть ID читача: ");
                    int personReaderIdPoverneno = sc.nextInt();
                    System.out.print("Внесіть дату повернення (yyyy-MM-dd): ");
                    String povernenoData = sc.nextLine();


                    Book bookPoverneno = bookDAO.getBookById(bookIdPoverneno);
                    PersonReader personReaderPoverneno = personReaderDAO.getPersonReaderById(personReaderIdPoverneno);
                    Date povernenoInData = DateUtil.convertStringIntoSqlDate(povernenoData);
                    Date vydanoInData = DateUtil.convertStringIntoSqlDate(vydanoData);
                    BookRegister bookRegisterPoverneno = new BookRegister(bookPoverneno, vydanoInData, personReaderPoverneno, povernenoInData);
                    bookRegisterDAO.insertBookRegister(bookRegisterPoverneno);

                    break;
                case "10":
                    List<Book> books = bookDAO.getAllBooks();
                    for(Book item: books) {
                        System.out.println(item);
                    }
                    break;
                case "11":
                    List<PersonReader> personReaders = personReaderDAO.getAllPersonReaders();
                    for(PersonReader item: personReaders) {
                        System.out.println(item);
                    }
                    break;
                case "12":
                    List<BookRegister> bookRegisters = bookRegisterDAO.getAllBookRegisters();
                    for(BookRegister item: bookRegisters) {
                        System.out.println(item);
                    }
                    break;
                case "13":
                    List<BookRegister> bookRegisterNepoverneni = bookRegisterDAO.getAllBookRegistersNepoverneni();
                    for(BookRegister item: bookRegisterNepoverneni) {
                        System.out.println(item);
                    }
                    break;
                case "14":
                    List<BookRegister> bookRegisterPoverneni = bookRegisterDAO.getAllBookRegistersPoverneni();
                    for(BookRegister item: bookRegisterPoverneni) {
                        System.out.println(item);
                    }
                    break;
                default:
                    return;
            }

        }

    }

}
