package com.maintenance.server.alkategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Alkategoriarepository extends JpaRepository<Alkategoria, Integer> {

    Optional<Alkategoria> findByAlkategorianev(String alkategorianev);

}
