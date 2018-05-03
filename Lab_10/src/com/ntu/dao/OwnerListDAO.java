package com.ntu.dao;

import java.util.List;

import com.ntu.domain.OwnerList;

import javafx.collections.ObservableList;



public interface OwnerListDAO {
    OwnerList getOwnerListByID(long id);
    ObservableList<OwnerList> getLoadByFirstNameAndLastName(String firstName, String lastName);
    ObservableList<OwnerList> getAllOwnerLists();
    boolean insertOwnerList(OwnerList ownerList);
    boolean updateOwnerList(OwnerList ownerList);
    boolean deleteOwnerList(long id);
    OwnerList getFirstOwnerList();
}
