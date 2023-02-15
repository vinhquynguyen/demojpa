package com.cybersoft.demojpa.repository;

import com.cybersoft.demojpa.dto.RoleDTO;
import com.cybersoft.demojpa.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Tham số thứ nhất trong JPArepository <Tên Entity, Kiểu dữ lệu khoá chính>
// @Component, @Service, @Repository, @Bean thường được khai báo ở tầng @Configuration
// Sẽ được lưu trữ trên Container dùng chung IOC
@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    List<Roles> findByName(String name);
}
