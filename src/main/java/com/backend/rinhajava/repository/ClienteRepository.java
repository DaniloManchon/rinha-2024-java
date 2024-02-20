package com.backend.rinhajava.repository;

import com.backend.rinhajava.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    Object findById(int id);
}
