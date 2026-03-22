package com.syst_financeiro.systfinanceiro.repositories;

import com.syst_financeiro.systfinanceiro.entities.LancamentosEntity;
import com.syst_financeiro.systfinanceiro.entities.LancamentosStatus;
import com.syst_financeiro.systfinanceiro.entities.LancamentosType;
import com.syst_financeiro.systfinanceiro.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LancamentosRepository extends JpaRepository<LancamentosEntity, UUID> {

    List<LancamentosEntity> findByUser(UserEntity user);

    List<LancamentosStatus> findByUserAndStatus(UserEntity user, LancamentosStatus status);

    List<LancamentosType> findByUserAndType(UserEntity user, LancamentosType type);
}
