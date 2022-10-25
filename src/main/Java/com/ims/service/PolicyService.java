package com.ims.service;

import com.ims.model.Policy.Policy;
import com.ims.model.Policy.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class PolicyService {

    //instance of CustomerRepository will be injected into this class:
    @Autowired
    PolicyRepository policyRepository;

    public void save(Policy policy) {
        policyRepository.save(policy);}

    public List<Policy> listAll() {
        return (List<Policy>) policyRepository.findAll();
    }

    public Policy get(Long id) {
        return policyRepository.findById(id).get();
    }

    public void delete(Long id) {
        policyRepository.deleteById(id);
    }

    public List<Policy> searchPolicy(String keyword) {
        return policyRepository.searchPolicy(keyword);
    }

}