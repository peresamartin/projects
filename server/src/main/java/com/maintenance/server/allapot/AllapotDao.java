package com.maintenance.server.allapot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllapotDao {

    @Autowired
    private Allapotrepository allapotrepository;

    public ResponseEntity<Allapot> save(String nev, int feladat_azon, String leiras)
    {
        Allapot uj=new Allapot();
        uj.setNev(nev);
        uj.setFeladatazon(feladat_azon);
        uj.setLeiras(leiras);
        return new ResponseEntity<>(this.allapotrepository.save(uj), HttpStatus.OK);
    }

    public List<Allapot> findAll()
    {
        return this.allapotrepository.findAll();
    }

    public ResponseEntity<Allapot> update(int azonosito, String nev, int feladat_azon, String leiras)
    {
        Allapot allapot=this.allapotrepository.getById(azonosito);
        allapot.setNev(nev);
        allapot.setFeladatazon(feladat_azon);
        allapot.setLeiras(leiras);
        return new ResponseEntity<>(this.allapotrepository.save(allapot), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getID(String nev, int feladat_azon)
    {
        Optional<Allapot> allapot=this.allapotrepository.findByNevAndFeladatazon(nev,feladat_azon);
        if(allapot.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(allapot.get().getAzonosito(),HttpStatus.OK);
        }
    }
}
