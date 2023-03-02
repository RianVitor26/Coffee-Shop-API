package com.br.api.repositories;

import com.br.api.models.CoffeeModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepos extends JpaRepository<CoffeeModel, Long> {
    
}







