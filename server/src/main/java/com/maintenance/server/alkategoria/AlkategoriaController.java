package com.maintenance.server.alkategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Alkategoria")
public class AlkategoriaController {

    private final AlkategoriaDao alkategoriaDao;

    @Autowired
    public AlkategoriaController(final AlkategoriaDao alkategoriaDao){this.alkategoriaDao=alkategoriaDao;}

    @GetMapping("/add/{alkategorianev}/{normaido}/{kategoria_azon}")
    public ResponseEntity<Alkategoria> add(
            @PathVariable String alkategorianev,
            @PathVariable int normaido,
            @PathVariable int kategoria_azon
    ){
        return this.alkategoriaDao.save(alkategorianev,normaido,kategoria_azon);
    }

    @GetMapping("/update/{azonosito}/{alkategorianev}/{normaido}/{kategoria_azon}")
    public ResponseEntity<Alkategoria> update(
            @PathVariable int azonosito,
            @PathVariable String alkategorianev,
            @PathVariable int normaido,
            @PathVariable int kategoria_azon
    ){
        return this.alkategoriaDao.update(azonosito,alkategorianev,normaido,kategoria_azon);
    }

    @GetMapping("/getID/{alkategorianev}")
    public ResponseEntity<Integer> getID(
            @PathVariable String alkategorianev
    ){
        return this.alkategoriaDao.getID(alkategorianev);
    }

    @GetMapping("/all")
    public List<Alkategoria> findAll()
    {
        return alkategoriaDao.findAll();
    }



}
