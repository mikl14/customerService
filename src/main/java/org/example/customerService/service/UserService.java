package org.example.customerService.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.example.customerService.entity.User;
import org.example.customerService.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final TokenGenerator tokenGenerator;

    public UserService(@Lazy UserRepository userRepository,@Lazy TokenGenerator tokenGenerator) {
        this.userRepository = userRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public String getUserTokenByUsername(String username)
    {
         User user = userRepository.findByUsername(username).orElse(null);
         if(user == null)
         {
             return "none";
         }
         else
         {
             return tokenGenerator.generateToken(user);
         }
    }

    public User getUser(String username)
    {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null)
        {
            return null;
        }
        else
        {
            return user;
        }
    }
}
