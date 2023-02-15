package com.cybersoft.demojpa.service;

import com.cybersoft.demojpa.dto.RoleDTO;
import com.cybersoft.demojpa.entity.Roles;
import com.cybersoft.demojpa.repository.RoleRepository;
import com.cybersoft.demojpa.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {



    //obfucate làm mờ code
    @Autowired
    RoleRepository roleRepository;


    @Override
    public List<RoleDTO> getAllRole() {


        List<Roles> list = roleRepository.findAll();
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data : list) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);

        }
        return dtoList;

    }

    @Override
    public List<RoleDTO> getRoleByName(String name){
        List<Roles> list = roleRepository.findByName(name);
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data : list) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);

        }
        return dtoList;
    }

}
