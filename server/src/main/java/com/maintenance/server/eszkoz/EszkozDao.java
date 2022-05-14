package com.maintenance.server.eszkoz;

import com.maintenance.server.feladat.Feladat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EszkozDao {

    @Autowired
    protected Eszkozrepository eszkozrepository;

    public ResponseEntity<Eszkoz> save(String nev, int kategoriaID, String leiras, int elhelyezkedes, Date periodusido,
                                       int hatralevoido,int feladat_azon)
    {
        Eszkoz uj=new Eszkoz();
        uj.setNev(nev);
        uj.setElhelyezkedes(elhelyezkedes);
        uj.setKategoriaID(kategoriaID);
        uj.setLeiras(leiras);
        uj.setPeriodusido(periodusido);
        uj.setHatralevoido(hatralevoido);
        uj.setFeladat_azon(feladat_azon);
        return new ResponseEntity<>(this.eszkozrepository.save(uj), HttpStatus.OK);
    }

    public ResponseEntity<Eszkoz> update(int azonosito, String nev, int kategoriaID, String leiras, int elhelyezkedes,
                                         Date periodusido, int hatralevoido, int feladat_azon)
    {
        Eszkoz uj=this.eszkozrepository.getById(azonosito);
        uj.setNev(nev);
        uj.setElhelyezkedes(elhelyezkedes);
        uj.setKategoriaID(kategoriaID);
        uj.setLeiras(leiras);
        uj.setPeriodusido(periodusido);
        uj.setHatralevoido(hatralevoido);
        uj.setFeladat_azon(feladat_azon);
        return new ResponseEntity<>(this.eszkozrepository.save(uj), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getId(String nev, int elhelyezkedes)
    {
        Optional<Eszkoz> eszkoz = this.eszkozrepository.findByNevAndElhelyezkedes(nev,elhelyezkedes);
        if(eszkoz.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(eszkoz.get().getAzonosito(),HttpStatus.OK);
        }

    }

    public List<Eszkoz> getAll()
    {
        return this.eszkozrepository.findAll();
    }

    public List<String> getAllEszkozWithKategoria()
    {
        return this.eszkozrepository.getAllEszkozWithKategoria();
    }

    public void updateperiod()
    {
        this.eszkozrepository.updateperiod();
    }
}
