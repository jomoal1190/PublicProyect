package com.umg.programacion2.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umg.programacion2.model.Role;
import com.umg.programacion2.model.User;
import com.umg.programacion2.repository.RoleRepository;
import com.umg.programacion2.repository.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
}

}
