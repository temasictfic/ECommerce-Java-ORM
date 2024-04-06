package com.tobeto.pairwork_orm.services.rules.abstracts;

public interface UserBusinessRuleService {
    void checkIfUsernameAlreadyExists(String username);

    void checkIfEmailAlreadyExists(String email);
}
