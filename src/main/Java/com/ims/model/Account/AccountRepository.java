package com.ims.model.Account;

import com.ims.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT account FROM Account account WHERE " +
            "lower(account.username) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(account.password) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(account.usertype) LIKE lower(CONCAT('%', :keyword, '%'))")
    public List<Account> search(@Param("keyword") String keyword);

    @Query(value = "SELECT u FROM Account u WHERE u.username =:username")
    public Account findUsers(@Param("username") String username);
}