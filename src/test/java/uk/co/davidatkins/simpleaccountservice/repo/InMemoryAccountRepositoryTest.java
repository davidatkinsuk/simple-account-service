package uk.co.davidatkins.simpleaccountservice.repo;

import org.junit.Before;
import org.junit.Test;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import static org.junit.Assert.assertEquals;

public class InMemoryAccountRepositoryTest {

    private InMemoryAccountRepository repo;

    @Before
    public void setup() {
        repo = new InMemoryAccountRepository();
    }

    @Test
    public void getAllAccounts_empty() {

        assertEquals(0,repo.getAccount().size());

    }

    @Test
    public void getAllAccounts_singleEntry() {

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

    @Test
    public void getAllAccounts_twoEntries() {

        repo.addAccount(
                Account.builder()
                        .id(1)
                        .accountNumber("account1")
                        .firstName("firstName1")
                        .secondName("secondName1")
                        .build()
        );

        repo.addAccount(
                Account.builder()
                        .id(2)
                        .accountNumber("account2")
                        .firstName("firstName2")
                        .secondName("secondName2")
                        .build()
        );

        assertEquals(2,repo.getAccount().size());

        Account firstAccount = repo.getAccount().get(0);
        assertEquals(1,firstAccount.getId());
        assertEquals("account1",firstAccount.getAccountNumber());
        assertEquals("firstName1",firstAccount.getFirstName());
        assertEquals("secondName1",firstAccount.getSecondName());

        Account secondAccount = repo.getAccount().get(1);
        assertEquals(2,secondAccount.getId());
        assertEquals("account2",secondAccount.getAccountNumber());
        assertEquals("firstName2",secondAccount.getFirstName());
        assertEquals("secondName2",secondAccount.getSecondName());

    }



}
