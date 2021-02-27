package com.sagar.main.controller;

import java.util.List;

import com.sagar.main.entity.User;
import com.sagar.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/list"})
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping({"/save"})
    public List<User> saveUser(@RequestBody User user) {
        this.userService.saveUser(user);
        return this.getAllUsers();
    }

    @PostMapping({"/saveMulti"})
    public List<User> saveListofUsers(@RequestBody List<User> list) {
        this.userService.saveMultipleUsers(list);
        return this.getAllUsers();
    }

    @DeleteMapping({"/deleteMulti"})
    public List<User> deleteListofUsers(@RequestBody List<User> list) {
        this.userService.deleteMultipleUsers(list);
        return this.getAllUsers();
    }

    @PutMapping({"/update"})
    public List<User> update(@RequestBody User user) {
        this.userService.updateUser(user);
        return this.getAllUsers();
    }

    @DeleteMapping({"/delete/{id}"})
    public List<User> delete(@PathVariable("id") int id) {
        this.userService.deleteUser(id);
        return this.getAllUsers();
    }

    @GetMapping({"/pagintion/{index}/{sizeOfPage}"})
    public List<User> allUsersWithPage(@PathVariable int index, @PathVariable int sizeOfPage) {
        return this.userService.usersWithPagination(index, sizeOfPage);
    }

    @GetMapping({"/pagintionWithSort/{sizeOfPage}/{sortBy}/{sortingOrder}"})
    public List<User> allUsersWithPageAndSort(@PathVariable int sizeOfPage, @PathVariable String sortingOrder, @PathVariable String sortBy) {
        return this.userService.usersWithPageAndSort(sizeOfPage, sortingOrder, new String[]{sortBy});
    }

    @GetMapping({"/find/{searchKeyword}"})
    public List<User> findByAny(@PathVariable String searchKeyword) {
        return this.userService.findByAnytg(searchKeyword);
    }

    @GetMapping({"/findByFname/{fname}"})
    public List<User> findByFname(@PathVariable String fname) {
        return this.userService.findByAnytg(fname);
    }
}
