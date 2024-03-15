package com.backend.rinhajava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class TransacaoModel {
    @Id
    private double id;
    @Column
    private float valor;
    @Column
    private double tipo;
    @Column
    private String descricao;
    @Column
    private Date dataTransacao;
    @Column
    private String destino;

}
