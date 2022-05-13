package com.maintenance.server.kategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategoriaDao {

    @Autowired
    private Kategoriarepository kategoriarepository;

    public ResponseEntity<Kategoria> save(String kategorianev, int alkategoria_azon, int eszkoz_azon) {
        Kategoria uj=new Kategoria();
        uj.setKategorianev(kategorianev);
        uj.setAlkategoriaazon(alkategoria_azon);
        uj.setEszkoz_azon(eszkoz_azon);
        return new ResponseEntity<>(this.kategoriarepository.save(uj), HttpStatus.OK);

    }

    public ResponseEntity<String> findByAlkategoria_azon(int alkategoria_azon)
    {
        Optional<Kategoria> kategoria = this.kategoriarepository.findByAlkategoriaazon(alkategoria_azon);
        if(kategoria.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(kategoria.get().getKategorianev(),HttpStatus.OK);
        }
    }

    public ResponseEntity<Integer> getID(String kategorianev)
    {
        Optional<Kategoria> kategoria=this.kategoriarepository.findByKategorianev(kategorianev);
        if(kategoria.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(kategoria.get().getAzonosito(),HttpStatus.OK);
        }
    }

    public ResponseEntity<Kategoria> update(int azonosito,String kategorianev,int alkategoriaazon, int eszkozazon)
    {
        Kategoria kategoria=this.kategoriarepository.getById(azonosito);
        kategoria.setKategorianev(kategorianev);
        kategoria.setAlkategoriaazon(alkategoriaazon);
        kategoria.setEszkoz_azon(eszkozazon);

        return new ResponseEntity<>(this.kategoriarepository.save(kategoria), HttpStatus.OK);
    }

    public List<Kategoria> getAll()
    {
        return this.kategoriarepository.findAll();
    }

}
