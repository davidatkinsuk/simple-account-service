package uk.co.davidatkins.simpleaccountservice.repo;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAccount() {
        return accounts;
    }

    @Override
    public void addAccount(Account build) {
        accounts.add(build);
    }
}
