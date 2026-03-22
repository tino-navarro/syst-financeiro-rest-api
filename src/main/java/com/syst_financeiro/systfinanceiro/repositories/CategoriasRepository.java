package com.syst_financeiro.systfinanceiro.repositories;

import com.syst_financeiro.systfinanceiro.entities.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriasRepository extends JpaRepository<CategoriasEntity, UUID> {

    List<CategoriasEntity> findByName(String name);
}
