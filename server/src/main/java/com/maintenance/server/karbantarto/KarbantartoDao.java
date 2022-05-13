package com.maintenance.server.karbantarto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KarbantartoDao {

    @Autowired
    private Karbantartorepository karbantartorepository;

    public ResponseEntity<Karbantarto> save(int felhasznaloAzon, int vegzettsegID,int feladat_azon) {
        Karbantarto uj=new Karbantarto();
        uj.setFelhasznaloazon(felhasznaloAzon);
        uj.setVegzettsegID(vegzettsegID);
        uj.setFeladatazon(feladat_azon);
        return new ResponseEntity<>(this.karbantartorepository.save(uj), HttpStatus.OK);
    }

    public ResponseEntity<Karbantarto> update(int azonosito, int felhasznaloAzon, int vegzettsegID,int feladat_azon) {
        Karbantarto karbantarto=this.karbantartorepository.getById(azonosito);
        karbantarto.setFelhasznaloazon(felhasznaloAzon);
        karbantarto.setVegzettsegID(vegzettsegID);
        karbantarto.setFeladatazon(feladat_azon);
        return new ResponseEntity<>(this.karbantartorepository.save(karbantarto), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getId(int vegzettsegID, int feladatazon, int felhasznaloazon)
    {
        Optional<Karbantarto> karbantarto = this.karbantartorepository.findByVegzettsegIDAndFeladatazonAndFelhasznaloazon(vegzettsegID,feladatazon,felhasznaloazon);
        if(karbantarto.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(karbantarto.get().getAzonosito(),HttpStatus.OK);
        }
    }
}
