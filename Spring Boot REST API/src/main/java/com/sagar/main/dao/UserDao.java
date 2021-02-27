package com.sagar.main.dao;

import com.sagar.main.entity.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByLname(String lname);

    @Query("FROM User u WHERE u.fname=?1 or u.lname=?1 or u.email=?1")
    List<User> findByAny(String any);

    List<User> findByFname(String fname);
}