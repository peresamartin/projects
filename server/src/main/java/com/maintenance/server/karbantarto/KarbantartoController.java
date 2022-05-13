package com.maintenance.server.karbantarto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/Karbantarto")
public class KarbantartoController {

    private final KarbantartoDao karbantartoDao;

    @Autowired
    public KarbantartoController(final KarbantartoDao karbantartoDao){this.karbantartoDao=karbantartoDao;}

    @GetMapping("/add/{felhasznalo_azon}/{vegzettsegID}/{feladat_azon}")
    public ResponseEntity<Karbantarto> add(
            @PathVariable int felhasznalo_azon,
            @PathVariable int vegzettsegID,
            @PathVariable int feladat_azon
    ){
        return this.karbantartoDao.save(felhasznalo_azon,vegzettsegID,feladat_azon);
    }

    @GetMapping("/update/{azonosito}/{felhasznalo_azon}/{vegzettsegID}/{feladat_azon}")
    public ResponseEntity<Karbantarto> update(
            @PathVariable int azonosito,
            @PathVariable int felhasznalo_azon,
            @PathVariable int vegzettsegID,
            @PathVariable int feladat_azon
    ){
        return this.karbantartoDao.update(azonosito,felhasznalo_azon,vegzettsegID,feladat_azon);
    }

    @GetMapping("/getID/{vegzettsegID}/{feladatazon}/{felhasznaloazon}")
    public ResponseEntity<Integer> getID(
            @PathVariable int vegzettsegID,
            @PathVariable int feladatazon,
            @PathVariable int felhasznaloazon
    ){
        return this.karbantartoDao.getId(vegzettsegID, feladatazon, felhasznaloazon);
    }
}
