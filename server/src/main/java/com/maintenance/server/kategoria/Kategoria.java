package com.maintenance.server.kategoria;

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
@Table(name = "KATEGORIA")
public class Kategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "kategorianev")
    private String kategorianev;

    @Column(name = "alkategoriaazon")
    private int alkategoriaazon;

    @Column(name = "eszkozazon")
    private int eszkoz_azon;

}
