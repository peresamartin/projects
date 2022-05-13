package com.maintenance.server.vegzettseg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Vegzettseg")
public class VegzettsegController {

    private final VegzettsegDao vegzettsegDao;

    @Autowired
    public VegzettsegController(final VegzettsegDao vegzettsegDao){this.vegzettsegDao=vegzettsegDao;}

    @GetMapping("/add/{vegzettsegnev}/{feladat_azon}/{kapcs_azon}")
    public ResponseEntity<Vegzettseg> add(
            @PathVariable final String vegzettsegnev,
            @PathVariable final int feladat_azon,
            @PathVariable final int kapcs_azon
    ){
        return this.vegzettsegDao.save(vegzettsegnev,feladat_azon,kapcs_azon);
    }

    @GetMapping("/getID/{vegzettsegnev}")
    public ResponseEntity<Integer> getId(
            @PathVariable String vegzettsegnev
    ){
        return this.vegzettsegDao.getID(vegzettsegnev);
    }

    @GetMapping("/update/{azonosito}/{vegzettsegnev}/{feladat_azon}/{kapcs_azon}")
    public ResponseEntity<Vegzettseg> update(
            @PathVariable final int azonosito,
            @PathVariable final String vegzettsegnev,
            @PathVariable final int feladat_azon,
            @PathVariable final int kapcs_azon
    ){
        return this.vegzettsegDao.update(azonosito,vegzettsegnev,feladat_azon,kapcs_azon);
    }

    @GetMapping("/all")
    public List<Vegzettseg> findAll()
    {
        return vegzettsegDao.findAll();
    }
}
