package uk.co.davidatkins.simpleaccountservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void getAccounts_empty() throws Exception {

        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity(String.format("http://localhost:%s/rest/account/json",port), String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        JSONAssert.assertEquals("[]", entity.getBody(), false);

    }

}
