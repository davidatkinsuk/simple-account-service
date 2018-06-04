package uk.co.davidatkins.simpleaccountservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {

    private long id;
    private String firstName;
    private String secondName;
    private String accountNumber;

}
