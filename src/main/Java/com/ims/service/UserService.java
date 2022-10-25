package com.ims.service;

import com.ims.model.User.User;
import com.ims.model.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class UserService {

    //instance of CustomerRepository will be injected into this class:
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);}

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<Object>queryAllIds(){
        return userRepository.queryAllIds();
    }

    public List<Object>queryAllIAgentsIds(){
        return userRepository.queryAllIAgentsIds();
    }




    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> search(String keyword) {
        return userRepository.search(keyword);
    }

}