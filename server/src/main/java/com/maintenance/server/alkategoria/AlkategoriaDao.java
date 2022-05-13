package com.maintenance.server.alkategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlkategoriaDao {

    @Autowired
    private Alkategoriarepository alkategoriarepository;

    public ResponseEntity<Alkategoria> save(String alkategorianev, int normaido,int kategoria_azon)
    {
        Alkategoria uj=new Alkategoria();
        uj.setAlkategorianev(alkategorianev);
        uj.setNormaido(normaido);
        uj.setKategoria_azon(kategoria_azon);
        return new ResponseEntity<>(this.alkategoriarepository.save(uj), HttpStatus.OK);
    }

    public List<Alkategoria> findAll()
    {
        return this.alkategoriarepository.findAll();
    }

    public ResponseEntity<Alkategoria> update(int azonosito, String alkategorianev, int normaido, int kategoria_azon)
    {
        Alkategoria alkategoria=this.alkategoriarepository.getById(azonosito);
        alkategoria.setAlkategorianev(alkategorianev);
        alkategoria.setNormaido(normaido);
        alkategoria.setKategoria_azon(kategoria_azon);
        return new ResponseEntity<>(this.alkategoriarepository.save(alkategoria), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getID(String alkategorianev)
    {
        Optional<Alkategoria> alkategoria=this.alkategoriarepository.findByAlkategorianev(alkategorianev);
        if(alkategoria.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(alkategoria.get().getAzonosito(),HttpStatus.OK);
        }
    }

}
