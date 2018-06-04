package uk.co.davidatkins.simpleaccountservice.repo;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void deleteAccount(long id) {
        accounts = accounts.stream().filter(a -> a.getId() != id).collect(Collectors.toList());
    }
}
