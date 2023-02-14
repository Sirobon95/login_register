package com.casemodul04.coltroller;

import com.casemodul04.model.Account;
import com.casemodul04.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class SigninController {
    @Autowired
    AccountService accountService;
    @PostMapping
    public ResponseEntity<String> register(@RequestBody Account account){

        if (accountService.findAccountByUsername(account.getUsername()) == null){
//            if (accountService.findAccountByPhone(account.getPhonenumber()) == null){
                accountService.save(account);
                return new ResponseEntity(HttpStatus.OK);
//            }else {
//                return new ResponseEntity(HttpStatus.BAD_REQUEST);
//            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
