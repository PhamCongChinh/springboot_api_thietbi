package com.api.thietbihq.service;

import com.api.thietbihq.entity.User;
import com.api.thietbihq.security.UserPrincipal;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
