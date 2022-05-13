package com.maintenance.server.vegzettseg;

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
@Table(name = "VEGZETTSEG")
public class Vegzettseg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "vegzettsegnev")
    private String vegzettsegnev;

    @Column(name = "feladatazon")
    private int feladat_azon;

    @Column(name = "kapcsazon")
    private int kapcs_azon;

}
