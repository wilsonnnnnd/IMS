package com.ims.model.Policy;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static org.springframework.data.repository.query.parser.Part.Type.LIKE;

@Repository //with Spring Data JPA, you don't have to write any Database access objects (DAO) code. At runtime, Spring Data JPA automatically generates the implementation code.
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    /*
    As with Spring Data JPA, you don't have to write any DAO code.
    Just declare an interface that extends the CrudRepository interface
    which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
    At runtime, Spring Data JPA automatically generates the implementation code.

    NOTE: that we must specify the type of the model class and type of the primary key field when extending the JPA/CrudRepository interface
    EX: CrudRepository<Pokemon, Long>
    */

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT policy FROM Policy policy WHERE " +
            "lower(policy.policy_number) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(policy.policy_type) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(policy.agent_list) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(policy.description) LIKE lower(CONCAT('%', :keyword, '%'))")
    List<Policy> searchPolicy(@Param("keyword") String keyword);
}