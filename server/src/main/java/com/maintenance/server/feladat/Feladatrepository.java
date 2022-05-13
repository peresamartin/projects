package com.maintenance.server.feladat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Feladatrepository  extends JpaRepository<Feladat, Integer> {

    Optional<Feladat> findByNev(String nev);

    @Query(value = "SELECT feladat.nev,feladat.leiras,feladat.idotartam,allapot.statusz FROM `feladat` INNER JOIN allapot " +
            "ON allapot.feladatazon=feladat.allapotazon",nativeQuery = true)
    public List<String> feladatadatok();



}
