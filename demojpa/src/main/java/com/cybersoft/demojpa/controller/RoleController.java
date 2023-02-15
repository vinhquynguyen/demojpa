package com.cybersoft.demojpa.controller;

import com.cybersoft.demojpa.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleService roleService; //hoặc dùng RoleServiceImp roleServiceImp

    @GetMapping("")
    public ResponseEntity<?> getAllRole(){

        return new  ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name) {

        return new  ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }


//    @Autowired
//    RoleRepository roleRepository;
//
//
//
//    @GetMapping("")
//    public ResponseEntity<?> getAllRole(){
//
//        List<Roles> list = roleRepository.findAll();
//        List<RoleDTO> dtoList = new ArrayList<>();
//
//        for(Roles data : list){
//            RoleDTO roleDTO = new RoleDTO();
//            roleDTO.setId(data.getId());
//            roleDTO.setName(data.getName());
//            roleDTO.setDesc(data.getDesc());
//
//            dtoList.add(roleDTO);
//        }
//
//        return new ResponseEntity<>(dtoList, HttpStatus.OK);
//    }

//    @Autowired
//    RoleRepository roleRepository;
//
//
//
//    @GetMapping("")
//    public ResponseEntity<List<Roles>> getAllRole(){
//
//
//        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
//    }

}
