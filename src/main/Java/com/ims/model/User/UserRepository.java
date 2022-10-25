package com.ims.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //with Spring Data JPA, you don't have to write any Database access objects (DAO) code. At runtime, Spring Data JPA automatically generates the implementation code.
public interface UserRepository extends JpaRepository<User, Long> {

    /*
    As with Spring Data JPA, you don't have to write any DAO code.
    Just declare an interface that extends the CrudRepository interface
    which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
    At runtime, Spring Data JPA automatically generates the implementation code.

    NOTE: that we must specify the type of the model class and type of the primary key field when extending the JPA/CrudRepository interface
    EX: CrudRepository<Pokemon, Long>
    */

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT user FROM User user WHERE " +
            "lower(user.firstname) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.lastname) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.address) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.email) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.sex) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.dob) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.employment_status) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.risk_rate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(user.role) LIKE lower(CONCAT('%', :keyword, '%'))")
    public List<User> search(@Param("keyword") String keyword);

    @Query(value = "select user.firstname,user.lastname,policyHolderRecord from User user,PolicyHolderRecord policyHolderRecord where user.id = policyHolderRecord.customerId")
    List<Object> queryAllRecord();

    @Query(value = "select user.firstname,user.lastname from User user")
    List<Object> queryAllIds();

    @Query(value = "select user.firstname,user.lastname from User user where user.role = 'Agent'")
    List<Object> queryAllIAgentsIds();

}