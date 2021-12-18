package sk.metatim.eshop.service.impl;

import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.account.AccountDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationRequestDTO;
import sk.metatim.eshop.dto.account.AccountRegistrationResponseDTO;
import sk.metatim.eshop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountRegistrationResponseDTO register(AccountRegistrationRequestDTO request) {
        return null;
    }

    @Override
    public boolean delete(String uuid, String username, String password) {
        return false;
    }

    @Override
    public AccountDTO update(AccountDTO dto) {
        return null;
    }
}
