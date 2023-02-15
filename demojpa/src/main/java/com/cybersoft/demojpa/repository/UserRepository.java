package com.cybersoft.demojpa.repository;

import com.cybersoft.demojpa.entity.Roles;
import com.cybersoft.demojpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findByEmailAndPassword (String email, String password);


    /**
     * @Query This is a query command written by JQl
     * It will interact with Entity class
     */
    @Query("select u from users as u join roles as r on u.roles.id = r.id where u.email = ?1 and r.name = ?2") //nativeQuery = "true"
    List<Users> getUserByEmailAndRoleName(String email, String roleName);


    @Query("select u from users as u")
    List<Users> getAllUser();
    //public List<Map<String,Object>>
}
