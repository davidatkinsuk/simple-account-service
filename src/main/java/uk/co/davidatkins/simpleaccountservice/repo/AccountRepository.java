package uk.co.davidatkins.simpleaccountservice.repo;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAccounts();

    void addAccount(Account build);

    void deleteAccount(long i);
}
