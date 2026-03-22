package com.syst_financeiro.systfinanceiro.repositories;

import com.syst_financeiro.systfinanceiro.entities.SubCategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubCategoriasRepository extends JpaRepository<SubCategoriasEntity, UUID> {

    List<SubCategoriasEntity> findByName(String name);

}
