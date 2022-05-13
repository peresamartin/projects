package com.maintenance.server.vegzettseg;

import com.maintenance.server.alkategoria.Alkategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegzettsegDao {

    @Autowired
    private Vegzettsegrepository vegzettsegrepository;

    public ResponseEntity<Vegzettseg> save(String vegzettsegnev,int feladat_azon,int kapcs_azon) {
        Vegzettseg uj=new Vegzettseg();
        uj.setVegzettsegnev(vegzettsegnev);
        uj.setKapcs_azon(kapcs_azon);
        uj.setFeladat_azon(feladat_azon);
        return new ResponseEntity<>(this.vegzettsegrepository.save(uj), HttpStatus.OK);

    }

    public ResponseEntity<Integer> getID(String vegzettsegnev)
    {
        Optional<Vegzettseg> vegzettseg=this.vegzettsegrepository.findByVegzettsegnev(vegzettsegnev);
        if(vegzettseg.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(vegzettseg.get().getAzonosito(),HttpStatus.OK);
        }
    }

    public List<Vegzettseg> findAll()
    {
        return this.vegzettsegrepository.findAll();
    }

    public ResponseEntity<Vegzettseg> update(int azonosito,String vegzettsegnev, int feladat_azon, int kapcs_azon)
    {
        Vegzettseg vegzettseg=this.vegzettsegrepository.getById(azonosito);
        vegzettseg.setVegzettsegnev(vegzettsegnev);
        vegzettseg.setFeladat_azon(feladat_azon);
        vegzettseg.setKapcs_azon(kapcs_azon);

        return new ResponseEntity<>(this.vegzettsegrepository.save(vegzettseg), HttpStatus.OK);
    }
}
