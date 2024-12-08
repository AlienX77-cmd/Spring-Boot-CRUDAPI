package com.kittipak.crudapi.services;

import com.kittipak.crudapi.entity.User;

import java.util.List;

public interface UserService {
    User save(User user); //บันทึกข้อมูลผู้ใช้ในระบบ
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
