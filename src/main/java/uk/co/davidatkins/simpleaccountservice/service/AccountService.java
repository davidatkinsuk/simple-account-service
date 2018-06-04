package uk.co.davidatkins.simpleaccountservice.service;

import uk.co.davidatkins.simpleaccountservice.model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest/account/json")
@Produces({MediaType.APPLICATION_JSON})
public interface AccountService {

    @GET
    List<Account> getAll();

    @POST
    SimpleResponse addAccount(Account account);

    @DELETE
    @Path("{id}")
    SimpleResponse delete(@PathParam("id") long id);

}
