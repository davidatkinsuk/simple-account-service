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
import uk.co.davidatkins.simpleaccountservice.model.Account;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void getAccounts_empty() throws Exception {

        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity(getUrl(""), String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        JSONAssert.assertEquals("[]", entity.getBody(), false);

    }

    @Test
    public void addAccount() throws Exception {

        Account testAccount = Account.builder().id(1).build();

        ResponseEntity<String> postEntity =new TestRestTemplate().postForEntity(getUrl(""),testAccount,String.class);
        assertEquals(HttpStatus.OK, postEntity.getStatusCode());

        JSONAssert.assertEquals("{ \"message\" : \"account has been successfully added\" }" , postEntity.getBody(), false);

    }

    private String getUrl(String path) {
        return String.format("http://localhost:%s/rest/account/json%s",port,path);
    }

}
