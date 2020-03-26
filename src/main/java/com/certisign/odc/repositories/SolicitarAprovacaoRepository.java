package com.certisign.odc.repositories;

import com.certisign.odc.entities.SolicitarAprovacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitarAprovacaoRepository extends JpaRepository<SolicitarAprovacao, Long> {

    @Query("select aliasOfEntity from SolicitarAprovacao aliasOfEntity where aliasOfEntity.email = ?1")
    List<SolicitarAprovacao> findByEmail(String email);

    List<SolicitarAprovacao> findByName(String name);

}
