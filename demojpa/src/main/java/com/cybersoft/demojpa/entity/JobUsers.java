package com.cybersoft.demojpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "sub_job")
//@IdClass(IdJobUsers.class)
public class JobUsers {

//    @Id
//    private int userId;
//
//    @Id
//    private int jobId;

    @EmbeddedId
    IdJobUsers idJobUsers;

}
