package sk.metatim.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.metatim.eshop.dto.account.AccountDTO;
import sk.metatim.eshop.dto.account.AccountDeletionRequestDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationRequestDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationResponseDTO;
import sk.metatim.eshop.helper.Crypto;
import sk.metatim.eshop.service.AccountService;

@RestController("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    Crypto crypto;

    @PostMapping("/register")
    public AccountRegistrationResponseDTO register(@RequestBody AccountRegistrationRequestDTO dto){

        String hashedPassword = crypto.hash(dto.getPassword());
        dto.setPassword(hashedPassword);

        return accountService.register(dto);
    }

    @PostMapping("/delete")
    public boolean delete(AccountDeletionRequestDTO dto){

        return accountService.delete(
                dto.getUuid(),
                dto.getUsername(),
                dto.getPassword()
        );
    }

    @PostMapping("/update")
    public AccountDTO update(AccountDTO dto){

        return accountService.update(dto);
    }
}
