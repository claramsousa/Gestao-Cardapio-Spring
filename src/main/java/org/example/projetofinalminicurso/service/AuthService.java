package org.example.projetofinalminicurso.service;

import org.example.projetofinalminicurso.dto.LoginRequestDTO;
import org.example.projetofinalminicurso.entities.User;
import org.example.projetofinalminicurso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(LoginRequestDTO data) {
        return userRepository.findByLogin(data.login())
                .map(user -> user.getPassword().equals(data.password()))
                .orElse(false);
    }
}