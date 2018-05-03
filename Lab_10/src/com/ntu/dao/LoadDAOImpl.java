package com.ntu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ntu.ConnectionFactory;
import com.ntu.domain.Load;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoadDAOImpl implements LoadDAO {

    @Override
    public Load getLoadById(long id) {

        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM load WHERE id=" + id)
        )
        {
            if(rs.next())
            {

                return extractLoadFromResultSet(rs);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public ObservableList<Load>  getLoadByTypeAndCustomer(String type, String customer) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM load WHERE type=? AND customer=?"))
        {

            ps.setString(1, type);
            ps.setString(2, customer);

            ResultSet rs = ps.executeQuery();
            ObservableList<Load> loads = FXCollections.observableArrayList();

            while(rs.next())
            {
                Load load = extractLoadFromResultSet(rs);
                loads.add(load);
            }

            return loads;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public ObservableList<Load> getAllLoads() {

        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from load")
        )
        {

            ObservableList<Load> loads = FXCollections.observableArrayList();

            while(rs.next())
            {
                Load load = extractLoadFromResultSet(rs);
                loads.add(load);
            }

            return loads;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;
    }

    @Override
    public boolean insertLoad(Load load) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO load(type, customer, made, weight) VALUES (?, ?, ?, ?)");
        )
        {

            ps.setString(1, load.getType());
            ps.setString(2, load.getCustomer());
            ps.setInt(3, load.getMade());
            ps.setInt(4, load.getWeight());

            int i = ps.executeUpdate();

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean updateLoad(Load load) {


        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE load set type = ?, customer = ?, made = ?, weight = ? WHERE id=?");
             )
        {
            ps.setString(1, load.getType());
            ps.setString(2, load.getCustomer());
            ps.setInt(3, load.getMade());
            ps.setInt(4, load.getWeight());
            ps.setLong(5, load.getId());

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
    public boolean deleteLoad(long id) {

        //try-with-resources
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM load WHERE id=?");
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
    public Load getFirstLoad() {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM load ORDER BY id limit 1" );
        )
        {


            if(rs.next())
            {

                return extractLoadFromResultSet(rs);


            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;
    }


    private Load extractLoadFromResultSet(ResultSet rs) throws SQLException {

        Load load = new Load();
        load.setId(rs.getLong("id"));
        load.setType( rs.getString("type") );
        load.setCustomer( rs.getString("customer") );
        load.setMade( rs.getInt("made") );
        load.setWeight( rs.getInt("weight") );

        return load;

    }



}
