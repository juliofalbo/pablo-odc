package com.certisign.odc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class SolicitarAprovacao {

    public SolicitarAprovacao(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public SolicitarAprovacao() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

}
