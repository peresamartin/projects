package com.maintenance.server.karbantarto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Karbantartorepository extends JpaRepository<Karbantarto, Integer> {

    Optional<Karbantarto> findByVegzettsegIDAndFeladatazonAndFelhasznaloazon(int vegzettsegID, int feladatazon, int felhasznaloazon);

}
