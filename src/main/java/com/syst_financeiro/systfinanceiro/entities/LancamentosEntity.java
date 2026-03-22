package com.syst_financeiro.systfinanceiro.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_lancamentos")
public class LancamentosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(length = 100, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LancamentosType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private LancamentosStatus status;

    @Column(nullable = false, precision = 14, scale = 2) //precision = 14 → total de dígitos | scale = 2 → duas casas decimais
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //vários lançamentos podem usar a mesma categoria e vários lançamentos podem usar a mesma subcategoria
    @JoinColumn(name = "category_id", nullable = false)
    private CategoriasEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private SubCategoriasEntity subcategory;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private FormasPagamentos paymentMethod;

    @Column(length = 1000)
    private String observation;

    @Column(nullable = false)
    private LocalDate inclusionDate; // DATA DE INCLUSÃO DA CONTA NO SISTEMA

    @Column
    private LocalDate dueDate; //DATA DE VENCIMENTO

    @Column
    private LocalDate transactionDate; // DATA DO FATURAMENTO DA CONTA


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LancamentosType getType() {
        return type;
    }

    public void setType(LancamentosType type) {
        this.type = type;
    }

    public LancamentosStatus getStatus() {
        return status;
    }

    public void setStatus(LancamentosStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CategoriasEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriasEntity category) {
        this.category = category;
    }

    public SubCategoriasEntity getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategoriasEntity subcategory) {
        this.subcategory = subcategory;
    }

    public FormasPagamentos getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(FormasPagamentos paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDate getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(LocalDate inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
