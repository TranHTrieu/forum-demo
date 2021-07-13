package com.fsoft.demo.service;

import com.fsoft.demo.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO changePassword(Long id, String newPassword);

    UserDTO save(UserDTO newUser);
}
