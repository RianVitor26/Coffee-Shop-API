package com.br.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.models.UserModel;

public interface UserRepos extends JpaRepository<UserModel, Long>{
    
}