package com.syst_financeiro.systfinanceiro.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_subcategorias")
public class SubCategoriasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
