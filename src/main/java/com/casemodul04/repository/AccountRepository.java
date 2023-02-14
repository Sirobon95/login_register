package com.casemodul04.repository;

import com.casemodul04.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface AccountRepository extends PagingAndSortingRepository <Account,Long>{
   Account findAccountByUsername(String username);

   @Query(nativeQuery = true, value = "SELECT * FROM Account WHERE phonenumber = :phonenumber")
   Account findAccountByPhone(@Param("phonenumber")String phonenumber);
}
