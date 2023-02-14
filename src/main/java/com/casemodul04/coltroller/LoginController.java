package com.casemodul04.coltroller;

import com.casemodul04.model.Account;
import com.casemodul04.model.dto.AccountToken;
import com.casemodul04.service.AccountService;
import com.casemodul04.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountToken login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account accounts = accountService.findAccountByUsername(account.getUsername());
        AccountToken accountToken = new AccountToken(accounts.getUsername(),accounts.getPassword(),token,accounts.getRoles());
        return accountToken;
    }
}