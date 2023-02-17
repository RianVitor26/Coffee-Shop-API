package com.br.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.api.models.UserModel;

@Repository
public interface UserRepos extends JpaRepository<UserModel, Long>{
    
}