package com.certisign.odc.services;

import com.certisign.odc.entities.SolicitarAprovacao;
import com.certisign.odc.repositories.SolicitarAprovacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SolicitarAprovacaoService {

    private SolicitarAprovacaoRepository repository;

    public SolicitarAprovacaoService(SolicitarAprovacaoRepository repository) {
        this.repository = repository;
    }

    public List<SolicitarAprovacao> findAll(){
        return this.repository.findAll();
    }

    public SolicitarAprovacao findById(final Long id){
        return this.repository.findById(id).orElseThrow(() -> new NoSuchElementException("Nenhum objeto [SolicitarAprovacao] encontrado"));
    }

    public void createMassTest(){
        repository.save(new SolicitarAprovacao("Pablo", "pablo@certisign.com"));
        repository.save(new SolicitarAprovacao("Julio", "julio@gmail.com"));
    }

    public SolicitarAprovacao save(SolicitarAprovacao newSave){
        return repository.save(newSave);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
