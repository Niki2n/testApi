package com.api.ligaInterview.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "catalogs", indexes = @Index(name = "name_idx", columnList = "name"))
public class CatalogEntity implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @OneToMany(mappedBy = "catalog",fetch = FetchType.LAZY)
    private List<ElementEntity> elements;

    public CatalogEntity() {
    }

    public CatalogEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
