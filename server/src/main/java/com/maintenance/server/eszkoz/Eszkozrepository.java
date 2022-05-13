package com.maintenance.server.eszkoz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Eszkozrepository extends JpaRepository<Eszkoz, Integer> {

    Optional<Eszkoz> findByNevAndElhelyezkedes(String nev, int elhelyezkedes);

    @Query(value = "SELECT * FROM `eszkoz` WHERE `hatralevoido`>0",nativeQuery = true)
    public List<Eszkoz> periodusidoszamitas();

    @Query(value = "SELECT eszkoz.nev,eszkoz.leiras,eszkoz.elhelyezkedes,eszkoz.periodusido,eszkoz.hatralevoido,kategoria.kategorianev,alkategoria.alkategorianev,alkategoria.normaido FROM `eszkoz` INNER JOIN kategoria ON eszkoz.kategoriaID=kategoria.eszkozazon INNER JOIN alkategoria ON kategoria.alkategoriaazon=alkategoria.kategoriaazon",nativeQuery = true)
    public List<String> getAllEszkozWithKategoria();

}
