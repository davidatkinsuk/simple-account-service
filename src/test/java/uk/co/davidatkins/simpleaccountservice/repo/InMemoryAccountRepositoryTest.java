package uk.co.davidatkins.simpleaccountservice.repo;

import org.junit.Before;
import org.junit.Test;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import static org.junit.Assert.assertEquals;

public class InMemoryAccountRepositoryTest {

    private InMemoryAccountRepository repo;

    private Account testAccount1;
    private Account testAccount2;

    @Before
    public void setup() {
        repo = new InMemoryAccountRepository();

        testAccount1 = Account.builder()
                .id(1)
                .accountNumber("account1")
                .firstName("firstName1")
                .secondName("secondName1")
                .build();

        testAccount2 = Account.builder()
                .id(2)
                .accountNumber("account2")
                .firstName("firstName2")
                .secondName("secondName2")
                .build();

    }

    @Test
    public void getAllAccounts_empty() {

        assertEquals(0,repo.getAccount().size());

    }

    @Test
    public void getAllAccounts_singleEntry() {

        repo.addAccount(testAccount1);

        assertEquals(1,repo.getAccount().size());

        assertIsTestAccount1(repo.getAccount().get(0));

    }

    @Test
    public void getAllAccounts_twoEntries() {

        repo.addAccount(testAccount1);
        repo.addAccount(testAccount2);

        assertEquals(2,repo.getAccount().size());

        assertIsTestAccount1(repo.getAccount().get(0));
        assertIsTestAccount2(repo.getAccount().get(1));

    }

    @Test
    public void deleteAccount() {

        repo.addAccount(testAccount1);
        repo.addAccount(testAccount2);
        assertEquals(2,repo.getAccount().size());

        repo.deleteAccount(1);

        assertEquals(1,repo.getAccount().size());
        assertIsTestAccount2(repo.getAccount().get(0));

    }

    private void assertIsTestAccount1(Account account) {
        assertEquals(1,account.getId());
        assertEquals("account1",account.getAccountNumber());
        assertEquals("firstName1",account.getFirstName());
        assertEquals("secondName1",account.getSecondName());
    }

    private void assertIsTestAccount2(Account account) {
        assertEquals(2,account.getId());
        assertEquals("account2",account.getAccountNumber());
        assertEquals("firstName2",account.getFirstName());
        assertEquals("secondName2",account.getSecondName());
    }

}
