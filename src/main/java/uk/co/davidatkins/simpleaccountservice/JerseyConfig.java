package uk.co.davidatkins.simpleaccountservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import uk.co.davidatkins.simpleaccountservice.service.AccountServiceImpl;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
        register(AccountServiceImpl.class);
    }
}
