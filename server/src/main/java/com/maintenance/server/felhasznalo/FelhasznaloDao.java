package com.maintenance.server.felhasznalo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FelhasznaloDao {
    @Autowired
    private Felhasznalorepository felhasznalorepository;

    public boolean letezik(String felhasznalonev, String jelszo)
    {
        return this.felhasznalorepository.existsFelhasznaloByFelhasznalonevAndJelszo(felhasznalonev,jelszo);
    }

    public ResponseEntity<Felhasznalo> updateFelhasznalo(int felhasznaloId ,String felhasznalonev,String jelszo,
                                                         String nev, String szerepkor, int kapcs_azon)
    {
        Felhasznalo felhasznalo1= this.felhasznalorepository.getById(felhasznaloId);
        felhasznalo1.setFelhasznalonev(felhasznalonev);
        felhasznalo1.setJelszo(jelszo);
        felhasznalo1.setKapcs_azon(kapcs_azon);
        felhasznalo1.setNev(nev);
        felhasznalo1.setSzerepkor(szerepkor);
        return new ResponseEntity<>(this.felhasznalorepository.save(felhasznalo1), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getID(String felhasznalonev, String jelszo)
    {
        Optional<Felhasznalo> felhasznalo = this.felhasznalorepository.findByFelhasznalonevAndJelszo(felhasznalonev,jelszo);
        if(felhasznalo.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(felhasznalo.get().getAzonosito(),HttpStatus.OK);
        }
    }

    public ResponseEntity<Felhasznalo> save(String felhasznalonev,String jelszo,String nev, String szerepkor, int kapcs_azon)
    {
        Felhasznalo uj=new Felhasznalo();
        uj.setFelhasznalonev(felhasznalonev);
        uj.setJelszo(jelszo);
        uj.setNev(nev);
        uj.setSzerepkor(szerepkor);
        uj.setKapcs_azon(kapcs_azon);
        return new ResponseEntity<>(this.felhasznalorepository.save(uj),HttpStatus.OK);
    }

    public List<String> getAllSzerepkor()
    {
        return this.felhasznalorepository.getAllSzerepkor();
    }

    public ResponseEntity<String> getSzerepkor(String felhasznalonev,String jelszo)
    {
        Optional<Felhasznalo> felhasznalo = this.felhasznalorepository.findByFelhasznalonevAndJelszo(felhasznalonev,jelszo);
        if(felhasznalo.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(felhasznalo.get().getSzerepkor(),HttpStatus.OK);
        }
    }

    public ResponseEntity<String> getNev(String felhasznalonev)
    {
        Optional<Felhasznalo> felhasznalo=this.felhasznalorepository.findByFelhasznalonev(felhasznalonev);
        if(felhasznalo.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(felhasznalo.get().getNev(),HttpStatus.OK);
        }
    }
}
