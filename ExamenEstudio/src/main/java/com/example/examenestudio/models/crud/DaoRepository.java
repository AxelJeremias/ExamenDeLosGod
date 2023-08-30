package com.example.examenestudio.models.crud;
import com.example.examenestudio.models.Users;

import java.util.List;

public interface DaoRepository<T>{
    List<T> findAll();
//    T findOne(Long id);

//    User Age(Long id);

    boolean save(T object);

    boolean saveinstructor(T object);

    boolean update(Users object);

    //    boolean update(T object);
    boolean delete(Long id);

    Users loadUserByUsernameAndPassword(String correo, String contra);
}
