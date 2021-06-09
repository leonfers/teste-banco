package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.UserDTO;
import com.leoncio.bancos.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
