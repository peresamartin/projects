package com.maintenance.server.feladat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeladatDao {

    @Autowired
    private Feladatrepository feladatrepository;

    public ResponseEntity<Feladat> save(String nev, int vegzettsegID,int eszkozAzon, String idotartam, int allapotAzon,
                                        String leiras, int kkapcs_azon)
    {
        Feladat uj = new Feladat();
        uj.setAllapotazon(allapotAzon);
        uj.setEszkozazon(eszkozAzon);
        uj.setIdotartam(idotartam);
        uj.setNev(nev);
        uj.setVegzettsegID(vegzettsegID);
        uj.setLeiras(leiras);
        uj.setKkapcsazon(kkapcs_azon);

        return new ResponseEntity<>(this.feladatrepository.save(uj), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getId(String nev)
    {
        Optional<Feladat> feladat = this.feladatrepository.findByNev(nev);
        if(feladat.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(feladat.get().getAzonosito(),HttpStatus.OK);
        }
    }

    public ResponseEntity<Feladat> update(int azonosito, String nev, int vegzettsegID, int eszkoz_azon,
                                          String idotartam, int allapot_azon, String leiras, int kkapcs_azon)
    {
        Feladat feladat=this.feladatrepository.getById(azonosito);
        feladat.setLeiras(leiras);
        feladat.setAllapotazon(allapot_azon);
        feladat.setEszkozazon(eszkoz_azon);
        feladat.setKkapcsazon(kkapcs_azon);
        feladat.setNev(nev);
        feladat.setIdotartam(idotartam);
        feladat.setVegzettsegID(vegzettsegID);
        return new ResponseEntity<>(this.feladatrepository.save(feladat), HttpStatus.OK);
    }

    public List<String> feladatok()
    {
        return this.feladatrepository.feladatadatok();
    }

    public ResponseEntity<Integer> getAllapotazon(String nev)
    {
        Optional<Feladat> feladat=this.feladatrepository.findByNev(nev);
        if(feladat.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(feladat.get().getAzonosito(),HttpStatus.OK);
        }
    }
}
