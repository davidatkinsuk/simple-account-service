package uk.co.davidatkins.simpleaccountservice.repo;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.Collections;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {
    @Override
    public List<Account> getAccount() {
        return Collections.emptyList();
    }
}
