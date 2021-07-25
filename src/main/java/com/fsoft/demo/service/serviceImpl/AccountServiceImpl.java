package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.AccountDTO;
import com.fsoft.demo.entity.Account;
import com.fsoft.demo.repository.AccountRepository;
import com.fsoft.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> findAll() {
        return null;
    }

    @Override
    public AccountDTO findById(Long id) {
        return null;
    }

    public UserDetails findByUsername(String username) {
        Account accountDto = accountRepository.findByUsername(username);
        if (accountDto == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(accountDto.getUsername(), accountDto.getPassword());
    }

    @Override
    public AccountDTO changePassword(Long id, String newPassword) {
        AccountDTO account = findById(id);
        account.setPassword(newPassword);
        return save(account);
    }

    @Override
    public AccountDTO save(AccountDTO newAccount) {
        return null;
    }

}
