package com.ntu.dao;

import com.ntu.domain.BookRegister;

import java.sql.Date;
import java.util.List;

public interface BookRegisterDAO {	
	
    BookRegister getBookRegisterById(long id);
    List<BookRegister> getBookRegisterByVydanoDt(Date vydanoDt);
    List<BookRegister> getAllBookRegisters();
    List<BookRegister> getAllBookRegistersNepoverneni();
    List<BookRegister> getAllBookRegistersPoverneni();
    boolean insertBookRegister(BookRegister bookRegister);
    boolean updateBookRegister(BookRegister bookRegister);
    boolean deleteBookRegister(long id);

}
