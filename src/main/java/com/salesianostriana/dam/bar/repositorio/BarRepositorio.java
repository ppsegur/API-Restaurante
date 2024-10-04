package com.salesianostriana.dam.bar.repositorio;

import com.salesianostriana.dam.bar.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepositorio extends JpaRepository<Bar, Long> {
}
