package com.lowes3.osp.service;

import com.lowes3.osp.dao.UserRepository;
import com.lowes3.osp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository UserRepository;

    @Override
    public User saveUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public User getUserById(Integer UserId) {
        Optional<User> User = UserRepository.findById(UserId);
        if (User.isPresent()) return User.get();
        else return null;
    }

    @Override
    public User updateUser(User User) {
        if(UserRepository.existsById(User.getUserId())) return UserRepository.save(User);
        else return null;
    }

    @Override
    public String deleteUserById(Integer UserId) {
        Optional<User> User = UserRepository.findById(UserId);
        if (User.isPresent()){
            UserRepository.deleteById(UserId);
            return "Deleted the User.";
        }
        else return "Could not find User by Id.";
    }
}
