package com.clubjhon.demo.servicios;
import com.clubjhon.demo.variables.Entrenador;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudEntrenador extends JpaRepository<Entrenador, Integer> {;
}