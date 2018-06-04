package uk.co.davidatkins.simpleaccountservice.repo;

import org.junit.Test;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import static org.junit.Assert.assertEquals;

public class InMemoryAccountRepositoryTest {

    @Test
    public void getAllAccounts_empty() {

        InMemoryAccountRepository repo = new InMemoryAccountRepository();
        assertEquals(0,repo.getAccount().size());

    }

    @Test
    public void getAllAccounts_singleEntry() {

        InMemoryAccountRepository repo = new InMemoryAccountRepository();
        repo.addAccount(
            Account.builder()
                    .id(1)
                    .accountNumber("account1")
                    .firstName("firstName1")
                    .secondName("secondName1")
                    .build()
        );

        assertEquals(1,repo.getAccount().size());

        Account firstAccount = repo.getAccount().get(0);
        assertEquals(1,firstAccount.getId());
        assertEquals("account1",firstAccount.getAccountNumber());
        assertEquals("firstName1",firstAccount.getFirstName());
        assertEquals("secondName1",firstAccount.getSecondName());


    }

}
