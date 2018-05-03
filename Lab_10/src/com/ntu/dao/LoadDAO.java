package com.ntu.dao;

import com.ntu.domain.Load;
import javafx.collections.ObservableList;

public interface LoadDAO {

    Load getLoadById(long id);
    ObservableList<Load> getLoadByTypeAndCustomer(String typee, String customer);
    ObservableList<Load>  getAllLoads();
    boolean insertLoad(Load load);
    boolean updateLoad(Load load);
    boolean deleteLoad(long id);
    Load getFirstLoad();

}
