package com.example.demo.service.implementation;

import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class UserSeviceImpl extends UserService{
    private final UserRepository repository;
    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }
    public User createData(User use){
        return repository.save(use);
    }
    public User createdData(User use){
        return repository.save(use);
    }
}
