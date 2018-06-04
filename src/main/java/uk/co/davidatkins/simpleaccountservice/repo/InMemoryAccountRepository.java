package uk.co.davidatkins.simpleaccountservice.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryAccountRepository implements AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAccounts() {
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
