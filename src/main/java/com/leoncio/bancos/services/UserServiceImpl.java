package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.UserDTO;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        try {
            return null;
        } catch (ConstraintViolationException| DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two users with the same email");
        }
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
