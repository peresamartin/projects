package com.maintenance.server.allapot;

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
@Table(name = "ALLAPOT")
public class Allapot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "statusz")
    private String nev;

    @Column(name = "feladatazon")
    private int feladatazon;

    @Column(name = "leiras")
    private String leiras;
}
