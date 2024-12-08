package com.kittipak.crudapi.controllers;

import com.kittipak.crudapi.entity.User;
import com.kittipak.crudapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") //Main path
public class UserController { //การบันทึกข้อมูลจะดำเนินการผ่าน Service, ผู้ที่เรียกใช้ Service คือ Controller

    // เชื่อม Service กับ Controller
    private UserService userService; //นำเอา UserService มาใช้

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // บันทึกข้อมูลของผู้ใช้เข้าไปในระบบ
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0); //ไม่แนบ id ไป จะแนบแค่ชื่อ-นามสกุล
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){ //Return List ของ Object: User ออกไป
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable  int id){ //PathVariable ให้ id ที่บรรทัด 34 และ 35 map กัน
        User myUser = userService.findById(id);
        if (myUser==null){
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส"+id);
        }
        return myUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        User myUser = userService.findById(id); //ค้นก่อนว่ามี id นี้ในระบบไหม
        if (myUser==null){
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส"+id);
        }
        userService.deleteById(id);
        return "ลบข้อมูลผู้ใช้"+id+"เรียบร้อยแล้ว";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }
}
