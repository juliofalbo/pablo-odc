package com.certisign.odc.controllers;

import com.certisign.odc.entities.SolicitarAprovacao;
import com.certisign.odc.services.SolicitarAprovacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SolicitarAprovacaoController {

    private final SolicitarAprovacaoService service;

    public SolicitarAprovacaoController(SolicitarAprovacaoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("aprovacaoList", service.findAll());
        model.addAttribute("newAprovacao", new SolicitarAprovacao());
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid SolicitarAprovacao newAprovacao, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        service.save(newAprovacao);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }

}
