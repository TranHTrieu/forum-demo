package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.UserDTO;
import com.fsoft.demo.repository.UserRepository;
import com.fsoft.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO changePassword(Long id, String newPassword) {
        UserDTO user = findById(id);
        user.setPassword(newPassword);
        return save(user);
    }

    @Override
    public UserDTO save(UserDTO newUser) {
        return null;
    }

}
