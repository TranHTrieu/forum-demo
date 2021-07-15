package com.fsoft.demo.controller;

import com.fsoft.demo.dto.AccountDTO;
import com.fsoft.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountDTO getAccount(@PathVariable(value = "id") Long id){
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    public AccountDTO createAccount(@RequestBody AccountDTO newAccount){
        return accountService.save(newAccount);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountDTO> changePassword(@PathVariable(value = "id") Long id, @RequestBody String newPassword){
        AccountDTO account = accountService.changePassword(id, newPassword);
        return ResponseEntity.ok(account);
    }
}
