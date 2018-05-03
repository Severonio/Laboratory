package com.ntu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ntu.ConnectionFactory;
import com.ntu.domain.Load;
import com.ntu.domain.LoadRegister;
import com.ntu.domain.OwnerList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class LoadRegisterDAOImpl implements LoadRegisterDAO {

    @Override
    public LoadRegister getLoadRegisterById(long id) {

        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM loadRegister WHERE id=" + id);
        )
        {



            if(rs.next())
            {

                return extractLoadRegisterFromResultSet(rs);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }


        return null;
    }

    @Override
    public ObservableList<LoadRegister> getLoadRegisterByBroughtDt(Date broughtDt) {


        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM loadRegister WHERE broughtDt=? "))
        {

            ps.setDate(1, broughtDt);
            ResultSet rs = ps.executeQuery();
            ObservableList<LoadRegister> loadRegisters = FXCollections.observableArrayList();

            while(rs.next())
            {
                LoadRegister loadRegister = extractLoadRegisterFromResultSet(rs);
                loadRegisters.add(loadRegister);
            }

            return loadRegisters;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }


        return null;
    }

    @Override
    public ObservableList<LoadRegister> getAllLoadRegisters() {

        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM loadRegister");
        )
        {

            ObservableList<LoadRegister> loadRegisters = FXCollections.observableArrayList();

            while(rs.next())
            {
                LoadRegister loadRegister = extractLoadRegisterFromResultSet(rs);
                loadRegisters.add(loadRegister);
            }

            return loadRegisters;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public boolean insertLoadRegister(LoadRegister loadRegister) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(""
                     + "INSERT INTO loadRegister(loadId, broughtDt, ownerListId, takenDt) "
                     + "VALUES (?, ?, ?, ?)");
        )
        {

            ps.setLong(1, loadRegister.getLoad().getId());
            ps.setDate(2, loadRegister.getBroughtDt());
            ps.setLong(3, loadRegister.getOwnerList().getId());
            ps.setDate(4, loadRegister.getTakenDt());

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean updateLoadRegister(LoadRegister loadRegister) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(""
                     + " UPDATE loadRegister"
                     + "    set loadId = ?, broughtDt = ?, ownerlistId = ?, takenDt = ? "
                     + " WHERE id=?");
        )
        {

            ps.setLong(1, loadRegister.getLoad().getId());
            ps.setDate(2, loadRegister.getBroughtDt());
            ps.setLong(3, loadRegister.getOwnerList().getId());
            ps.setDate(4, loadRegister.getTakenDt());
            ps.setLong(5, loadRegister.getId());

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteLoadRegister(long id) {

        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM loadRegister WHERE id=?");
        )
        {

            ps.setLong(1, id);

            int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public LoadRegister getFirstLoadRegister() {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM loadRegister ORDER BY id limit 1" );
        )
        {


            if(rs.next())
            {

                return extractLoadRegisterFromResultSet(rs);


            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;
    }

    private LoadRegister extractLoadRegisterFromResultSet(ResultSet rs) throws SQLException {

        LoadDAO loadDAO =  new LoadDAOImpl();
        OwnerListDAO ownerListDAO =  new OwnerListDAOImpl();

        Load load = loadDAO.getLoadById(rs.getLong("loadid"));
        OwnerList ownerList = ownerListDAO.getOwnerListByID(rs.getLong("ownerListid"));

        LoadRegister loadRegister = new LoadRegister();
        loadRegister.setId(rs.getLong("id"));
        loadRegister.setLoad( load );
        loadRegister.setBroughtDt( rs.getDate("broughtDt"));
        loadRegister.setOwnerList( ownerList);
        loadRegister.setTakenDt( rs.getDate("takenDt"));


        return loadRegister;

    }

}
