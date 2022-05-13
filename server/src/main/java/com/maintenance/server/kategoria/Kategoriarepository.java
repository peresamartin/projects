package com.maintenance.server.kategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Kategoriarepository extends JpaRepository<Kategoria, Integer> {

    Optional<Kategoria> findByAlkategoriaazon(int alkategoria_azon);

    Optional<Kategoria> findByKategorianev(String kategorianev);

}
