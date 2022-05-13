package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.conector.MySQLConnector;
import edu.fpdual.webservice.model.dao.City;
import edu.fpdual.webservice.model.manager.CityManager;
import edu.fpdual.webservice.model.manager.impl.CityManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CityService {

    private final CityManager cityManager;

    public CityService(CityManagerImpl cityManager){
        this.cityManager = cityManager;
    }

    public List<City> findAll() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.findAll(con);
        }
    }

    public City findById(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.findById(con, id);
        }
    }

    public boolean deleteCity(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.delete(con, id);
        }
    }

    public int createCity(City city) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.create(con, city);
        }
    }

    public boolean updateCity(City city) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.update(con, city);
        }
    }

}
