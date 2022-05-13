package com.maintenance.server.kategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Kategoria", produces="application/json")
public class KategoriaController {

    private final KategoriaDao kategoriaDao;

    @Autowired
    public KategoriaController(final KategoriaDao kategoriaDao){this.kategoriaDao=kategoriaDao;}

    @GetMapping("/add/{kategorianev}/{alkategoria_azon}/{eszkoz_azon}")
    public ResponseEntity<Kategoria> add(
            @PathVariable final String kategorianev,
            @PathVariable final int alkategoria_azon,
            @PathVariable final int eszkoz_azon
    ){
        return this.kategoriaDao.save(kategorianev,alkategoria_azon,eszkoz_azon);
    }

    @GetMapping("/update/{azonosito}/{kategorianev}/{alkategoria_azon}/{eszkoz_azon}")
    public ResponseEntity<Kategoria> update(
            @PathVariable final int azonosito,
            @PathVariable final String kategorianev,
            @PathVariable final int alkategoria_azon,
            @PathVariable final int eszkoz_azon
    ){
        return this.kategoriaDao.update(azonosito,kategorianev,alkategoria_azon,eszkoz_azon);
    }

    @GetMapping("/findByAlkategiroaAzon/{alkategoria_azon}")
    public ResponseEntity<String> findByAlkategoria_azon(
            @PathVariable final int alkategoria_azon
    ){
        return this.kategoriaDao.findByAlkategoria_azon(alkategoria_azon);
    }

    @GetMapping("/getID/{kategorianev}")
    public ResponseEntity<Integer> getID(
            @PathVariable final String kategorianev
    ){
        return this.kategoriaDao.getID(kategorianev);
    }

    @GetMapping("/getAll")
    public List<Kategoria> getAll()
    {
        return this.kategoriaDao.getAll();
    }


}