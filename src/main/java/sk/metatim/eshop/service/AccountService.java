package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.account.AccountDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationRequestDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationResponseDTO;

public interface AccountService {

    AccountRegistrationResponseDTO register(AccountRegistrationRequestDTO request);

    boolean delete(String uuid, String username, String password);

    AccountDTO update(AccountDTO dto);
}
