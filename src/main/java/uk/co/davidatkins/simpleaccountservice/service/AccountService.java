package uk.co.davidatkins.simpleaccountservice.service;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest/account/json")
@Produces({MediaType.APPLICATION_JSON})
public interface AccountService {

    @GET
    List<Account> getAll();

    @POST
    SimpleResponse addAccount();

}
