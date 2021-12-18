package sk.metatim.eshop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    Crypto crypto;

    @PostMapping("/register")
    public AccountRegistrationResponseDTO register(@RequestBody AccountRegistrationRequestDTO dto) {

        String hashedPassword = crypto.hash(dto.getPassword());
        dto.setPassword(hashedPassword);

        logger.info(String.format("Recieved request [%s][%s]",
                "/account/register",
                dto.toString()
        ));

        return accountService.register(dto);
    }

    @PostMapping("/delete")
    public boolean delete(AccountDeletionRequestDTO dto) {

        logger.info(String.format("Recieved request [%s][%s]",
                "/account/delete",
                dto.toString()
        ));

        return accountService.delete(
                dto.getUuid(),
                dto.getUsername(),
                dto.getPassword()
        );
    }

    @PostMapping("/update")
    public AccountDTO update(AccountDTO dto) {

        logger.info(String.format("Recieved request [%s][%s]",
                "/account/update",
                dto.toString()
        ));

        return accountService.update(dto);
    }
}
