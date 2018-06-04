package uk.co.davidatkins.simpleaccountservice.service;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.davidatkins.simpleaccountservice.model.Account;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    @DirtiesContext
    public void getAccounts_empty() throws Exception {

        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity(getUrl(""), String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        JSONAssert.assertEquals("[]", entity.getBody(), false);

    }

    @Test
    @DirtiesContext
    public void addAccount() throws Exception {

        Account testAccount = Account.builder().id(1).build();

        ResponseEntity<String> postEntity =new TestRestTemplate().postForEntity(getUrl(""),testAccount,String.class);
        assertEquals(HttpStatus.OK, postEntity.getStatusCode());

        JSONAssert.assertEquals("{ \"message\" : \"account has been successfully added\" }" , postEntity.getBody(), false);

    }

    @Test
    @DirtiesContext
    public void addAccountAndRetrieveAllAccounts() throws Exception {

        Account testAccount1 = Account.builder()
                .id(1)
                .accountNumber("accountNumber1")
                .firstName("firstName1")
                .secondName("secondName1")
                .build();

        ResponseEntity<String> postEntity =new TestRestTemplate().postForEntity(getUrl(""),testAccount1,String.class);
        assertEquals(HttpStatus.OK, postEntity.getStatusCode());

        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity(getUrl(""), String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        JSONAssert.assertEquals(
                "[{ \"id\": 1, \"accountNumber\" : \"accountNumber1\", \"firstName\": \"firstName1\", \"secondName\": \"secondName1\"}]",
                entity.getBody(),
                false);

    }

    @Test
    @DirtiesContext
    public void deleteAccount() throws Exception {

        addTestAccount(1);
        addTestAccount(2);
        addTestAccount(3);

        ResponseEntity<String> getEntityBefore =
                new TestRestTemplate().getForEntity(getUrl(""), String.class);
        assertEquals(HttpStatus.OK, getEntityBefore.getStatusCode());
        JSONAssert.assertEquals(
                "[" +
                        "{ \"id\": 1, \"accountNumber\" : \"accountNumber1\", \"firstName\": \"firstName1\", \"secondName\": \"secondName1\"}," +
                        "{ \"id\": 2, \"accountNumber\" : \"accountNumber2\", \"firstName\": \"firstName2\", \"secondName\": \"secondName2\"}," +
                        "{ \"id\": 3, \"accountNumber\" : \"accountNumber3\", \"firstName\": \"firstName3\", \"secondName\": \"secondName3\"}" +
                        "]",
                getEntityBefore.getBody(),
                false);

        // https://github.com/spring-projects/spring-boot/issues/12009
        ResponseEntity<String> deleteResponse =new TestRestTemplate().exchange(getUrl("/2"),HttpMethod.DELETE,null,String.class);
        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
        JSONAssert.assertEquals("{ \"message\" : \"account successfully deleted\" }" , deleteResponse.getBody(), false);

        ResponseEntity<String> getEntityAfter =
                new TestRestTemplate().getForEntity(getUrl(""), String.class);
        assertEquals(HttpStatus.OK, getEntityAfter.getStatusCode());
        JSONAssert.assertEquals(
                "[" +
                        "{ \"id\": 1, \"accountNumber\" : \"accountNumber1\", \"firstName\": \"firstName1\", \"secondName\": \"secondName1\"}," +
                        "{ \"id\": 3, \"accountNumber\" : \"accountNumber3\", \"firstName\": \"firstName3\", \"secondName\": \"secondName3\"}" +
                        "]",
                getEntityAfter.getBody(),
                false);

    }

    private void addTestAccount(int id) throws JSONException {

        Account testAccount = Account.builder()
                .id(id)
                .accountNumber("accountNumber" + id)
                .firstName("firstName" + id)
                .secondName("secondName" + id)
                .build();

        ResponseEntity<String> postEntity =new TestRestTemplate().postForEntity(getUrl(""),testAccount,String.class);
        assertEquals(HttpStatus.OK, postEntity.getStatusCode());
        JSONAssert.assertEquals("{ \"message\" : \"account has been successfully added\" }" , postEntity.getBody(), false);

    }

    private String getUrl(String path) {
        return String.format("http://localhost:%s/rest/account/json%s",port,path);
    }

}
