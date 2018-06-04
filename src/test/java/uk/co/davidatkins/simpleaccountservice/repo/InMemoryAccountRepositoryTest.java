package uk.co.davidatkins.simpleaccountservice.repo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryAccountRepositoryTest {

    @Test
    public void getAllAccounts_empty() {

        InMemoryAccountRepository repo = new InMemoryAccountRepository();
        assertEquals(0,repo.getAccount().size());

    }

}
