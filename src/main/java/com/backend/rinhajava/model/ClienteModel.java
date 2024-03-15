package com.backend.rinhajava.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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

    //relação de muitas transacoes para um unico cliente
    @Nullable
    @OneToMany
    private List<TransacaoModel> transacaoList;
}
