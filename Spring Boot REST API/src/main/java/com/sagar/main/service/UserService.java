package com.sagar.main.service;

import com.sagar.main.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> usersWithPageAndSort(int size, String order, String... sortBy);

    void deleteMultipleUsers(List<User> users);

    void saveMultipleUsers(List<User> users);

    List<User> findByAnytg(String any);

    List<User> usersWithPagination(int index, int size);

    List<User> findByFname(String fname);

    List<User> findByLname(String lname);
}
