package com.maintenance.server.alkategoria;

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
@Table(name = "ALKATEGORIA")
public class Alkategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "alkategorianev")
    private String alkategorianev;

    @Column(name = "normaido")
    private int normaido;

    @Column(name = "kategoriaazon")
    private int kategoria_azon;


}
