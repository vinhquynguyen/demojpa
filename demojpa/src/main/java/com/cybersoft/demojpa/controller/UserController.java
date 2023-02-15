package com.cybersoft.demojpa.controller;

import com.cybersoft.demojpa.dto.UserDTO;
import com.cybersoft.demojpa.payload.LoginRequest;
import com.cybersoft.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Tạo một user controller
/**
 * Thêm 1 user
 * Lấy user theo email và password
 *
 */



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){


        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/getUserByEmailAndRoleName")
    public ResponseEntity<?> getUserByEmailAndRoleName(
            @RequestParam("email") String email,
            @RequestParam("roleName") String roleName
    ){


        return new ResponseEntity<>(userService.getUserByEmailAndRoleName(email,roleName),HttpStatus.OK);
    }


}
