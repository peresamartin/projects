package com.maintenance.server.felhasznalo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Felhasznalorepository extends JpaRepository<Felhasznalo, Integer> {

    boolean existsFelhasznaloByFelhasznalonevAndJelszo(String felhasznalonev,String jelszo);

    Optional<Felhasznalo> findByFelhasznalonevAndJelszo(String felhasznalonev, String jelszo);

    Optional<Felhasznalo> findByFelhasznalonev(String felhasznalonev);

    @Query(value = "SELECT distinct szerepkor FROM users", nativeQuery = true)
    public List<String> getAllSzerepkor();
}
