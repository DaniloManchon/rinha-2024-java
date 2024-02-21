package com.backend.rinhajava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class ClienteModel {
    @Id
    private int id;
    @Column
    private double limite;
    @Column
    private double saldoInicial;

}
