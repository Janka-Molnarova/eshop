package sk.metatim.eshop.dto.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDeletionRequestDTO {

    private String uuid;
    private String username;
    private String password;
}
