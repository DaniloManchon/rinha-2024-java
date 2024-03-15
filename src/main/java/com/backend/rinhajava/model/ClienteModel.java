package com.backend.rinhajava.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @JsonAlias("id")
    private int idCliente;
    @Column
    private int limite;
    @Column
    private int saldoInicial;

    //relação de muitas transacoes para um unico cliente
    @Nullable
    @OneToMany
    private List<TransacaoModel> transacaoList;

    public ClienteModel(int idCliente, int limite, int saldoInicial, @Nullable List<TransacaoModel> transacaoList) {
        this.idCliente = idCliente;
        this.limite = limite;
        this.saldoInicial = saldoInicial;
        this.transacaoList = transacaoList;
    }
}
