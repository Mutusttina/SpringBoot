package com.sagar.main.serviceimpl;

import java.util.List;

import com.sagar.main.dao.UserDao;
import com.sagar.main.entity.User;
import com.sagar.main.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
    }

    public List<User> getAllUsers() {
        log.debug("Find all called");
        return this.userDao.findAll();
    }

    public void saveUser(User user) {
        this.userDao.save(user);
    }

    public void saveMultipleUsers(List<User> users) {
        this.userDao.saveAll(users);
    }

    public void updateUser(User user) {
        this.userDao.save(user);
    }

    public void deleteUser(int id) {
        this.userDao.deleteById(id);
    }

    public void deleteMultipleUsers(List<User> users) {
        this.userDao.deleteInBatch(users);
    }

    public List<User> usersWithPagination(int index, int size) {
        Pageable usersWithLimit = PageRequest.of(index, size);
        Page<User> users = this.userDao.findAll(usersWithLimit);
        return users.getContent();
    }

    public List<User> usersWithPageAndSort(int size, String order, String... sortBy) {
        if (order.toUpperCase().equals("ASC")) {
            PageRequest.of(0, size, Sort.by(sortBy).ascending());
        }

        Pageable usersWithSort = PageRequest.of(0, size, Sort.by(sortBy).descending());
        List<User> users = this.userDao.findAll(usersWithSort).getContent();
        return users;
    }

    public List<User> findByAnytg(String param) {
        List<User> users = this.userDao.findByAny(param);
        return users;
    }

    public List<User> findByLname(String lname) {
        return this.userDao.findByLname(lname);
    }

    public List<User> findByFname(String fname) {
        return this.userDao.findByFname(fname);
    }
}