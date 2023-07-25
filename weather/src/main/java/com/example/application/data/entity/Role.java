package com.example.application.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.NaturalId;



@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="role_seq_gen")
    @SequenceGenerator(name="role_seq_gen", sequenceName="roles_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
}