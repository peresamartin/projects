package com.maintenance.server.karbantarto;

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
@Table(name = "KARBANTARTO_KAPCS")
public class Karbantarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "azonosito", updatable = false)
    private int azonosito;

    @Column(name = "felhasznaloazon")
    private int felhasznaloazon;

    @Column(name = "vegzettsegID")
    private int vegzettsegID;

    @Column(name = "feladatazon")
    private int feladatazon;

}
