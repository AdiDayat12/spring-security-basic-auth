package com.nseva.basic_auth.services;

import com.nseva.basic_auth.models.entities.User;
import com.nseva.basic_auth.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));
    }

    public User register (User user) {
        boolean existingUser = userRepo.findByEmail(user.getEmail()).isPresent();

        if (existingUser) {
            throw new RuntimeException("Email already exist");
        }

        String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

        return userRepo.save(user);
    }

    public Iterable<User> findAll () {
        return userRepo.findAll();
    }
}
