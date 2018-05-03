package com.ntu.dao;

import java.sql.Date;

import com.ntu.domain.LoadRegister;

import javafx.collections.ObservableList;

public interface LoadRegisterDAO {

    LoadRegister getLoadRegisterById(long id);
    ObservableList<LoadRegister> getLoadRegisterByBroughtDt(Date broughtDt);
    ObservableList<LoadRegister> getAllLoadRegisters();
    boolean insertLoadRegister(LoadRegister loadRegister);
    boolean updateLoadRegister(LoadRegister loadRegister);
    boolean deleteLoadRegister(long id);
    LoadRegister getFirstLoadRegister();

}
