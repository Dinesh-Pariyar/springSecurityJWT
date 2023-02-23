package com.backuppractise.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    userRepository userRepository;

    @Override
    public User SaveUser(User user) {
        userRepository.save(user);
        User user1 = new User();
        for(int i = 2; i<100000; i++){
            user1.setId(i);
            user1.setName("dinesh"+i);
            user1.setAge(20);
            user1.setSalary(i+1000);
            user1.setMaritalStatus("married");
            userRepository.save(user1);

        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
