package com.project.bootcamp.repository;

import com.project.bootcamp.model.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActiveRepository extends JpaRepository<Active, Long> {

    public Optional<Active> findByName(String name);

    @Query("SELECT active FROM Active active WHERE active.name = :name AND active.id <> :id ")
    public Optional<Active> findByName(String name, Long id);
}
