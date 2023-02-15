package com.cybersoft.demojpa.service;

import com.cybersoft.demojpa.dto.UserDTO;
import com.cybersoft.demojpa.entity.Roles;
import com.cybersoft.demojpa.entity.Users;
import com.cybersoft.demojpa.payload.LoginRequest;
import com.cybersoft.demojpa.repository.UserRepository;
import com.cybersoft.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserRepository userRepository;


    @Override
    public boolean login(LoginRequest loginRequest){



        return userRepository.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword()).size() > 0;
    }

    @Override
    public boolean insertUser(UserDTO userDTO) {

        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());

        Users users = new Users();

        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setFullName(userDTO.getFullName());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roles);

        try{
            userRepository.save(users);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<UserDTO> getAllUser(){

        List<UserDTO> list = new ArrayList<>();
        for(Users user : userRepository.getAllUser()){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setFullName(user.getFullName());
            userDTO.setAvatar(user.getAvatar());

            list.add(userDTO);

        }

        return list;
    }

    @Override
    public List<UserDTO> getUserByEmailAndRoleName(String email,String roleName) {
        List<UserDTO> list = new ArrayList<>();
        for(Users user : userRepository.getUserByEmailAndRoleName(email,roleName)){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setFullName(user.getFullName());
            userDTO.setAvatar(user.getAvatar());

            list.add(userDTO);

        }


        return list ;
    }


}
