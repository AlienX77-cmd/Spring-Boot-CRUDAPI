package com.kittipak.crudapi.services;

import com.kittipak.crudapi.entity.User;
import com.kittipak.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAction implements UserService{

    private UserRepository userRepository; //เป็น Interface ที่นำเอาคุณสมบัติ JPA Repository มาใช้

    @Autowired //ใช้ UserRepository ใน UserServiceAction
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id){
        Optional<User> result = userRepository.findById(id);
        User data=null;
        if (result.isPresent()){
            data=result.get();
        }
        else {
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส"+id);
        }
        return data;
    }

    @Override
    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}
