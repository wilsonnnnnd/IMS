package com.ims.service;

import com.ims.model.Account.Account;
import com.ims.model.Account.AccountRepository;
import com.ims.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class AccountService {
    //instance of CustomerRepository interface will be injected into this class:
    @Autowired
    AccountRepository repo;
    public void save(Account account) {
        repo.save(account);
    }
    public List<Account> listAll() {
        return (List<Account>) repo.findAll();
    }
    public Account get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Account findUsers(String username){
        return  repo.findUsers(username);
    }

    public List<Account> searchaccount(String keyword) {
        return repo.search(keyword);
    }




}
