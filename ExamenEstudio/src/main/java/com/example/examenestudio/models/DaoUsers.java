package com.example.examenestudio.models;

import com.example.examenestudio.models.crud.DaoRepository;
import com.example.examenestudio.utils.MySQLConnection;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsers implements DaoRepository<Users> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    @Override
    public List<Users> findAll() {
        return null;
    }

    public List<Users> findAllInstructores() {
        List<Users> userList = new ArrayList<>();

        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM USERS WHERE rol = 'INSTRUCTORE_ROLE';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Users user = new Users();
                user.setId(rs.getLong("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellidoP(rs.getString("apellidoP"));
                user.setApelldioM(rs.getString("apellidoM"));
                user.setCorreo(rs.getString("correo"));
                user.setContra(rs.getString("contra"));
                user.setCurp(rs.getString("curp"));
                user.setFecha(rs.getString("fecha"));
                user.setEstado(rs.getString("estado"));
                user.setRol(rs.getString("rol"));

                userList.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUsers.class.getName()).log(Level.SEVERE, "ERROR findAllInstructore" + e.getMessage());
        } finally {
            close();
        }

        return userList;
    }

    @Override
    public boolean save(Users object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO USERS (nombre, apellidoP, apellidoM, correo, contra, curp, fecha, estado, rol)" +
                    "values (?, ?, ?, ?, ?, ?, ?, 'ACTIVO', 'USER_ROLE');";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getNombre());
            pstm.setString(2, object.getApellidoP());
            pstm.setString(3, object.getApelldioM());
            pstm.setString(4, object.getCorreo());
            pstm.setString(5, object.getContra());
            pstm.setString(6, object.getCurp());
            pstm.setString(7, object.getFecha());
            int result = pstm.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUsers.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }

        return false;
    }


    @Override
    public boolean saveinstructor(Users object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO USERS (nombre, apellidoP, apellidoM, correo, contra, curp, fecha, estado, rol)" +
                    "values (?, ?, ?, ?, ?, ?, ?, 'ACTIVO', 'INSTRUCTORE_ROLE');";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getNombre());
            pstm.setString(2, object.getApellidoP());
            pstm.setString(3, object.getApelldioM());
            pstm.setString(4, object.getCorreo());
            pstm.setString(5, object.getContra());
            pstm.setString(6, object.getCurp());
            pstm.setString(7, object.getFecha());
            int result1 = pstm.executeUpdate();
            return result1 > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUsers.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }

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
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM USERS WHERE (correo =? and contra =?) and estado = 'ACTIVO';";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, correo);
            pstm.setString(2, contra);
            rs = pstm.executeQuery();

            if (rs.next()){
                Users user = new Users();
                user.setId(rs.getLong("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellidoP(rs.getString("apellidoP"));
                user.setApelldioM(rs.getString("apellidoM"));
                user.setCurp(rs.getString("curp"));
                user.setFecha(rs.getString("fecha"));
                user.setCorreo(rs.getString("correo"));
                user.setContra(rs.getString("contra"));
                user.setEstado(rs.getString("estado"));
                user.setRol(rs.getString("rol"));
                return user;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUsers.class.getName())
                    .log(Level.SEVERE, "credentials diferents: "+ e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    public Long findInstructorIdByName(String nombre) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT id FROM users WHERE nombre = ? AND rol = 'INSTRUCTORE_ROLE'";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUsers.class.getName()).log(Level.SEVERE, "Error encontrando el id", e);
        } finally {
            close();
        }
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
