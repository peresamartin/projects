package com.maintenance.server.eszkoz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@Access(value = AccessType.FIELD)
@Table(name = "ESZKOZ")
public class Eszkoz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "nev")
    private String nev;

    @Column(name = "kategoriaID")
    private int kategoriaID;

    @Column(name = "leiras")
    private String leiras;

    @Column(name = "elhelyezkedes")
    private int elhelyezkedes;

    @Column(name = "periodusido")
    private Date periodusido;

    @Column(name = "feladatazon")
    private int feladat_azon;

    @Column(name = "hatralevoido")
    private int hatralevoido;

}
