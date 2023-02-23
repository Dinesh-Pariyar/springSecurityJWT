package com.backuppractise.model;

import java.util.List;

public interface UserService {

     User SaveUser(User user);
     List<User> getAllUser();

}
