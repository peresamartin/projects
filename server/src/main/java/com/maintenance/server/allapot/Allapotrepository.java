package com.maintenance.server.allapot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Allapotrepository extends JpaRepository<Allapot, Integer> {

    Optional<Allapot> findByNevAndFeladatazon(String nev, int feladatazon);

}
