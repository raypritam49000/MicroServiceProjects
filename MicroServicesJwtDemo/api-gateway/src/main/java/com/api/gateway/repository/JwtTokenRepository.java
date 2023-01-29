package com.api.gateway.repository;

import com.api.gateway.entity.JwtToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken,String> {
}