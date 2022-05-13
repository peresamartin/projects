package com.maintenance.server.feladat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@Access(value = AccessType.FIELD)
@Table(name = "FELADAT")
public class Feladat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "nev")
    private String nev;

    @Column(name = "vegzettsegID")
    private int vegzettsegID;

    @Column(name = "eszkozazon")
    private int eszkozazon;

    @Column(name = "idotartam")
    private String idotartam;

    @Column(name = "allapotazon")
    private int allapotazon;

    @Column(name = "kkapcsazon")
    private int kkapcsazon;

    @Column(name = "leiras")
    private String leiras;

}
