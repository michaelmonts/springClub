package com.clubjhon.demo.servicios;
import com.clubjhon.demo.variables.Competicion;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudCompeticion extends JpaRepository<Competicion, Integer> {

}