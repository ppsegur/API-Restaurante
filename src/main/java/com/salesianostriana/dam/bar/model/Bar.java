package com.salesianostriana.dam.bar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bar {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 10)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;
    private String localizacion, descripcion, url;


    @ManyToMany
    @JoinTable(
            name="bar_tag",
            joinColumns = @JoinColumn(name = "bar_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")

    )
    private List<Tag> tags;
}

