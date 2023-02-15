package com.cybersoft.demojpa.service.imp;


import com.cybersoft.demojpa.dto.UserDTO;
import com.cybersoft.demojpa.entity.Users;
import com.cybersoft.demojpa.payload.LoginRequest;

import java.util.List;

public interface UserService {
    boolean login(LoginRequest loginRequest);
    boolean insertUser(UserDTO userDTO);

    List<UserDTO> getAllUser();
    List<UserDTO> getUserByEmailAndRoleName(String email,String roleName);

}
