package com.provider.model;

import static javax.persistence.CascadeType.ALL;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Provider
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @CNPJ
    @Column(nullable = false, unique = true)
    private String cnpj;

    @OneToOne(cascade = ALL, optional = false, orphanRemoval = true)
    private Address address;
}
