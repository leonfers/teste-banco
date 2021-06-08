package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserDTO save(UserDTO userDTO);

    public UserDTO findById(Integer id);

    public List<UserDTO> findAll();

    public void destroy();

}
