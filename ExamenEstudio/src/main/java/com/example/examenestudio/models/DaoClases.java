package com.example.examenestudio.models;

import com.example.examenestudio.models.crud.DaoRepository;
import com.example.examenestudio.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClases implements DaoRepository <Clases> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;


    @Override
    public List<Clases> findAll() {
        List<Clases> clasesList = new ArrayList<>();

        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM CLASES;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Clases clase = new Clases();
                clase.setId(rs.getLong("id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setDescripcion(rs.getString("descripcion"));
                clase.setEstado(rs.getString("estado"));
                clase.setInstructor(rs.getLong("instructor"));
                clasesList.add(clase);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoClases.class.getName()).log(Level.SEVERE, "Error en findAll: " + e.getMessage());
        } finally {
            close();
        }

        return clasesList;
    }

    public List<Clases> findAllClases(Long instructorId) {
        List<Clases> clasesList = new ArrayList<>();

        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM CLASES WHERE instructor = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, instructorId);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Clases clase = new Clases();
                clase.setId(rs.getLong("id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setDescripcion(rs.getString("descripcion"));
                clase.setEstado(rs.getString("estado"));
                clase.setInstructor(rs.getLong("instructor"));
                clasesList.add(clase);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoClases.class.getName()).log(Level.SEVERE, "Error en findAll: " + e.getMessage());
        } finally {
            close();
        }

        return clasesList;
    }

    public List<Clases> findAllActive() {
        List<Clases> clasesList = new ArrayList<>();

        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM CLASES WHERE estado = 'ACTIVO';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Clases clase = new Clases();
                clase.setId(rs.getLong("id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setDescripcion(rs.getString("descripcion"));
                clase.setEstado(rs.getString("estado"));
                clase.setInstructor(rs.getLong("instructor"));
                clasesList.add(clase);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoClases.class.getName()).log(Level.SEVERE, "Error en findAll: " + e.getMessage());
        } finally {
            close();
        }
        return clasesList;
    }

    @Override
    public boolean save(Clases object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO CLASES (nombre, descripcion, estado, instructor)" +
                    "values (?, ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getNombre());
            pstm.setString(2, object.getDescripcion());
            pstm.setString(3, object.getEstado());
            pstm.setLong(4, object.getInstructor());
            int result = pstm.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoClases.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {

            close();
        }

        return false;
    }


    @Override
    public boolean saveinstructor(Clases object) {
        return false;
    }

    @Override
    public boolean update(Users object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Users loadUserByUsernameAndPassword(String correo, String contra) {
        return null;
    }

    public void close(){
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        }catch (SQLException e){

        }
    }
}
