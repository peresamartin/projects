package com.maintenance.server.vegzettseg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Vegzettsegrepository extends JpaRepository<Vegzettseg, Integer> {

    Optional<Vegzettseg> findByVegzettsegnev(String vegzettsegnev);

}