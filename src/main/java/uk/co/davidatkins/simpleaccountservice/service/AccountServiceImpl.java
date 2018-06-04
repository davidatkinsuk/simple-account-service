package uk.co.davidatkins.simpleaccountservice.service;

import org.springframework.stereotype.Component;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import java.util.Collections;
import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public List<Account> getAll() {
        return Collections.emptyList();
    }

}
