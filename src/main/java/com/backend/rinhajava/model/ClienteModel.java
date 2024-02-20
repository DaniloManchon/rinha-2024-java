package com.backend.rinhajava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ClienteModel {
    @Id
    private int id;
    @Column
    private double limite;
    @Column
    private double saldoInicial;

}
