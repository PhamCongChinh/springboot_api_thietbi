package com.api.thietbihq.service;

import com.api.thietbihq.entity.Token;

public interface TokenService {
    Token createToken(Token token);
    Token findByToken(String token);
}
