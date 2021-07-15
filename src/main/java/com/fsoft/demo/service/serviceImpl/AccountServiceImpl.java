package com.fsoft.demo.service.serviceImpl;

import com.fsoft.demo.dto.AccountDTO;
import com.fsoft.demo.repository.AccountRepository;
import com.fsoft.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
