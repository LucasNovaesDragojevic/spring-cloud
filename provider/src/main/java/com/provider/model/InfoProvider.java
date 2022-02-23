package com.provider.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class InfoProvider 
{
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String state;

    private String address;
}
