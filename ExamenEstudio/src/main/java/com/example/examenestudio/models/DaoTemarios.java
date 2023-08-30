package com.example.examenestudio.models;

import com.example.examenestudio.models.crud.DaoRepository;
import com.example.examenestudio.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTemarios implements DaoRepository<Temarios> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Temarios> findAll() {
        return null;
    }

    @Override
    public boolean save(Temarios object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO TEMARIOS (descripcion, clase)" +
                    "values (?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getDescripcion());
            pstm.setLong(2, object.getClases());
            int result = pstm.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoTemarios.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean saveinstructor(Temarios object) {
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
