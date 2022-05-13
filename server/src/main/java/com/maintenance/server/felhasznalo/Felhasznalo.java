package com.maintenance.server.felhasznalo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@Access(value = AccessType.FIELD)
@Table(name = "USERS")
public class Felhasznalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "felhasznalonev")
    private String felhasznalonev;

    @Column(name = "jelszo")
    private String jelszo;

    @Column(name = "nev")
    private String nev;

    @Column(name = "szerepkor")
    private String szerepkor;

    @Column(name = "kapcsazon")
    private int kapcs_azon;

}
