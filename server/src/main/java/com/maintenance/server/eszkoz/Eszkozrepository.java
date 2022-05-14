package com.maintenance.server.eszkoz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface Eszkozrepository extends JpaRepository<Eszkoz, Integer> {

    Optional<Eszkoz> findByNevAndElhelyezkedes(String nev, int elhelyezkedes);

    @Query(value = "SELECT eszkoz.nev,eszkoz.leiras,eszkoz.elhelyezkedes,eszkoz.periodusido,eszkoz.hatralevoido," +
            "kategoria.kategorianev,alkategoria.alkategorianev,alkategoria.normaido " +
            "FROM `eszkoz` INNER JOIN kategoria ON eszkoz.kategoriaID=kategoria.eszkozazon " +
            "INNER JOIN alkategoria ON kategoria.alkategoriaazon=alkategoria.kategoriaazon",nativeQuery = true)
    public List<String> getAllEszkozWithKategoria();

    @Modifying
    @Transactional
    @Query(value = "UPDATE feladat INNER JOIN allapot ON allapot.feladatazon = feladat.allapotazon " +
            "INNER JOIN eszkoz ON eszkoz.feladatazon = feladat.eszkozazon " +
            "SET eszkoz.periodusido = DATE_ADD(eszkoz.periodusido, INTERVAL eszkoz.hatralevoido DAY) " +
            "WHERE allapot.statusz like \"kesz\" and eszkoz.periodusido<NOW() and eszkoz.hatralevoido>0;",nativeQuery = true)
    public void updateperiod();

}
