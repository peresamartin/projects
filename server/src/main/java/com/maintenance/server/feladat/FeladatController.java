package com.maintenance.server.feladat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Feladat")
public class FeladatController {

    private final FeladatDao feladatDao;

    @Autowired
    public FeladatController(final FeladatDao feladatDao){this.feladatDao=feladatDao;}

    @GetMapping("/add/{nev}/{vegzettsegID}/{eszkoz_azon}/{idotartam}/{allapot_azon}/{leiras}/{kkapcs_azon}")
    public ResponseEntity<Feladat> add(
            @PathVariable final String nev,
            @PathVariable final int vegzettsegID,
            @PathVariable final int eszkoz_azon,
            @PathVariable final String idotartam,
            @PathVariable final int allapot_azon,
            @PathVariable final String leiras,
            @PathVariable final int kkapcs_azon
    ){
        return this.feladatDao.save(nev, vegzettsegID, eszkoz_azon, idotartam,allapot_azon,leiras,kkapcs_azon);
    }

    @GetMapping("/getID/{nev}")
    public ResponseEntity<Integer> getID(
            @PathVariable final String nev
    ){
        return this.feladatDao.getId(nev);
    }

    @GetMapping("/getAllapotazon/{nev}")
    public ResponseEntity<Integer> getAllapotazon(
            @PathVariable final String nev
    ){
        return this.feladatDao.getAllapotazon(nev);
    }

    @GetMapping("/update/{azonosito}/{nev}/{vegzettsegID}/{eszkoz_azon}/{idotartam}/{allapot_azon}/{leiras}/{kkapcs_azon}")
    public ResponseEntity<Feladat> update(
            @PathVariable final int azonosito,
            @PathVariable final String nev,
            @PathVariable final int vegzettsegID,
            @PathVariable final int eszkoz_azon,
            @PathVariable final String idotartam,
            @PathVariable final int allapot_azon,
            @PathVariable final String leiras,
            @PathVariable final int kkapcs_azon
    ){
        return this.feladatDao.update(azonosito, nev, vegzettsegID, eszkoz_azon, idotartam,allapot_azon,leiras,kkapcs_azon);
    }

    @GetMapping("/getFeladatok")
    public List<String> getFeladatok()
    {
        return this.feladatDao.feladatok();
    }

}
