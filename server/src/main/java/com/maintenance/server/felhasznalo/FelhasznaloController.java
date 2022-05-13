package com.maintenance.server.felhasznalo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Felhasznalo")
public class FelhasznaloController {

    private final FelhasznaloDao felhasznaloDao;

    @Autowired
    public FelhasznaloController(final FelhasznaloDao felhasznaloDao) {
        this.felhasznaloDao = felhasznaloDao;
    }

    @GetMapping("/exitsByFelhasznalonevAndJelszo")
    public boolean exitsByFelhasznalonevAndJelszo(
            @RequestBody final Felhasznalo felhasznalo
    ) {
        return this.felhasznaloDao.letezik(felhasznalo.getFelhasznalonev(),felhasznalo.getJelszo());
    }

    @GetMapping("/getID/{felhasznalonev}/{jelszo}")
    public ResponseEntity<Integer> getID(
            @PathVariable final String felhasznalonev,
            @PathVariable final String jelszo
    ){
        return this.felhasznaloDao.getID(felhasznalonev,jelszo);
    }

    @GetMapping("/add/{felhasznalonev}/{jelszo}/{nev}/{szerepkor}/{kapcs_azon}")
    public ResponseEntity<Felhasznalo> add(
            @PathVariable final String felhasznalonev,
            @PathVariable final String jelszo,
            @PathVariable final String nev,
            @PathVariable final String szerepkor,
            @PathVariable final int kapcs_azon
    ){
        return this.felhasznaloDao.save(felhasznalonev,jelszo,nev,szerepkor,kapcs_azon);
    }

    @GetMapping("/login/{felhasznalonev}/{jelszo}")
    public boolean belepes(
            @PathVariable final String felhasznalonev,
            @PathVariable final String jelszo
    ){
        return this.felhasznaloDao.letezik(felhasznalonev,jelszo);
    }

    @GetMapping("/szerepkor/{felhasznalonev}/{jelszo}")
    public ResponseEntity<String> szerepkor(
            @PathVariable final String felhasznalonev,
            @PathVariable final String jelszo
    ){
        return this.felhasznaloDao.getSzerepkor(felhasznalonev,jelszo);
    }

    @GetMapping("/getNev/{felhasznalonev}")
    public ResponseEntity<String> getNev(
            @PathVariable final String felhasznalonev
    ) {
        return this.felhasznaloDao.getNev(felhasznalonev);
    }

    @GetMapping("/update/{azonosito}/{felhasznalonev}/{jelszo}/{nev}/{szerepkor}/{kapcs_azon}")
    public ResponseEntity<Felhasznalo> update(
            @PathVariable final int azonosito,
            @PathVariable final String felhasznalonev,
            @PathVariable final String jelszo,
            @PathVariable final String nev,
            @PathVariable final String szerepkor,
            @PathVariable final int kapcs_azon
    ){
        return this.felhasznaloDao.updateFelhasznalo(azonosito,felhasznalonev,jelszo,nev,szerepkor,kapcs_azon);
    }

    @GetMapping("/allszerepkor")
    public List<String> allSzerepkor()
    {
        return this.felhasznaloDao.getAllSzerepkor();
    }


}
