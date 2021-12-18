package sk.metatim.eshop.dto.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountRegistrationResponseDTO {

    private boolean success;
    private String username;
    private String userId;
    private String message;
}
