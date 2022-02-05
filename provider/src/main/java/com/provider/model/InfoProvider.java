package com.provider.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InfoProvider 
{
    @Id
    private final String id = UUID.randomUUID().toString();

    private String name;

    private String state;

    private String address;
}
