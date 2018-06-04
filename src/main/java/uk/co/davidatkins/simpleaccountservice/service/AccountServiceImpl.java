package uk.co.davidatkins.simpleaccountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.davidatkins.simpleaccountservice.model.Account;
import uk.co.davidatkins.simpleaccountservice.repo.AccountRepository;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.getAccounts();
    }

    @Override
    public SimpleResponse addAccount(Account account) {

        accountRepository.addAccount(account);

        return SimpleResponse.builder().message("account has been successfully added").build();
    }

}
