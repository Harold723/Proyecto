package com.proyecto.proyecto.repositrio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.modelo.avion;;

@Repository
public interface repositorio extends JpaRepository<avion, Integer> {

}
