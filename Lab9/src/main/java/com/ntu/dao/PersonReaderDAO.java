package com.ntu.dao;

import java.util.List;

import com.ntu.domain.PersonReader;



public interface PersonReaderDAO {
	PersonReader getPersonReaderById(long id);
    List<PersonReader> getBookByFirstNameAndLastName(String firstName, String lastName);
    List<PersonReader> getAllPersonReaders();
    boolean insertPersonReader(PersonReader personReader);
    boolean updatePersonReader(PersonReader personReader);
    boolean deletePersonReader(long id);
}
