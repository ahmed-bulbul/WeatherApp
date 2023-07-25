package com.example.application.data.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Status extends AbstractEntity {
    private String name;

}
