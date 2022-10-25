package com.ims.model.Policy;

import com.ims.model.User.User;
import javax.persistence.*;

import java.util.List;

@Entity
public class Policy {
    @Id
    //@GeneratedValue annotations to indicate that this field is primary key and its value is auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policy_number;
    private String policy_type;
    private String agent_list;
    private String description;

    @OneToMany(mappedBy = "policy" )
    private List <User> users;

    public Policy() {

    }

    public Policy(String policy_number, String policy_type, String agent_list, String description) {
        this.policy_number = policy_number;
        this.policy_type = policy_type;
        this.agent_list = agent_list;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public String getAgent_list() {
        return agent_list;
    }

    public void setAgent_list(String agent_list) {
        this.agent_list = agent_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}