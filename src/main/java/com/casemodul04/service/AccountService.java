package com.casemodul04.service;

import com.casemodul04.model.Account;
import com.casemodul04.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public void save(Account account){
        accountRepository.save(account);
    }
    public Account findAccountByPhone(String phonenumber){
        return accountRepository.findAccountByPhone(phonenumber);
    }

}
