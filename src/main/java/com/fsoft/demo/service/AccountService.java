package com.fsoft.demo.service;

import com.fsoft.demo.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> findAll();

    AccountDTO findById(Long id);

    AccountDTO changePassword(Long id, String newPassword);

    AccountDTO save(AccountDTO newAccount);
}
