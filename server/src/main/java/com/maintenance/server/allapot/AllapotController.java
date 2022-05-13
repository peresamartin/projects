package com.maintenance.server.allapot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Allapot")
public class AllapotController {

    private final AllapotDao allapotDao;

    @Autowired
    public AllapotController(final AllapotDao allapotDao){this.allapotDao=allapotDao;}

    @GetMapping("/add/{nev}/{feladat_azon}/{leiras}")
    public ResponseEntity<Allapot> add(
            @PathVariable String nev,
            @PathVariable int feladat_azon,
            @PathVariable String leiras
    ){
        return this.allapotDao.save(nev,feladat_azon,leiras);
    }

    @GetMapping("/update/{azonosito}/{nev}/{feladat_azon}/{leiras}")
    public ResponseEntity<Allapot> update(
            @PathVariable int azonosito,
            @PathVariable String nev,
            @PathVariable int feladat_azon,
            @PathVariable String leiras
    ){
        return this.allapotDao.update(azonosito,nev,feladat_azon,leiras);
    }

    @GetMapping("/getID/{nev}/{feladat_azon}")
    public ResponseEntity<Integer> getID(
            @PathVariable String nev,
            @PathVariable int feladat_azon
    ){
        return this.allapotDao.getID(nev,feladat_azon);
    }

    @GetMapping("/all")
    public List<Allapot> findAll()
    {
        return allapotDao.findAll();
    }

}
