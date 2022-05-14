package com.maintenance.server.eszkoz;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Data
@RestController
@EnableScheduling
@RequestMapping("/Eszkoz")
public class EszkozController {

    private final EszkozDao eszkozDao;

    @Autowired
    public EszkozController(final EszkozDao eszkozDao){this.eszkozDao=eszkozDao;}

    @GetMapping("/add/{nev}/{kategoriaID}/{leiras}/{elhelyezkedes}/{periodusido}/{hatralevoido}/{feladat_azon}")
    public ResponseEntity<Eszkoz> add(
            @PathVariable final String nev,
            @PathVariable final int kategoriaID,
            @PathVariable final String leiras,
            @PathVariable final int elhelyezkedes,
            @PathVariable final Date periodusido,
            @PathVariable final int hatralevoido,
            @PathVariable final int feladat_azon
    ){
        return this.eszkozDao.save(nev, kategoriaID, leiras, elhelyezkedes,periodusido,hatralevoido,feladat_azon);
    }

    @GetMapping("/update/{azonosito}/{nev}/{kategoriaID}/{leiras}/{elhelyezkedes}/{periodusido}/{hatralevoido}/{feladat_azon}")
    public ResponseEntity<Eszkoz> update(
            @PathVariable final int azonosito,
            @PathVariable final String nev,
            @PathVariable final int kategoriaID,
            @PathVariable final String leiras,
            @PathVariable final int elhelyezkedes,
            @PathVariable final Date periodusido,
            @PathVariable final int hatralevoido,
            @PathVariable final int feladat_azon
    ){
        return this.eszkozDao.update(azonosito,nev, kategoriaID, leiras, elhelyezkedes,periodusido,hatralevoido,feladat_azon);
    }

    @GetMapping("/getID/{nev}/elhelyezkedes")
    public ResponseEntity<Integer> getID(
            @PathVariable final String nev,
            @PathVariable final int elhelyezkedes
    ) {
        return this.eszkozDao.getId(nev,elhelyezkedes);
    }

    @GetMapping("/getAll")
    public List<Eszkoz> getAll()
    {
        return this.eszkozDao.getAll();
    }

    @GetMapping("/getAllEszkozWithKategoria")
    public List<String> getAllEszkozWithKategoria()
    {
        return this.eszkozDao.getAllEszkozWithKategoria();
    }

    @Scheduled(fixedDelay = 86400000L)
    public void update()
    {
        this.eszkozDao.updateperiod();
    }

}
