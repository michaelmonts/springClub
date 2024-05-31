package com.clubjhon.demo.servicios;
import com.clubjhon.demo.variables.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudJugador extends JpaRepository<Jugador, Integer>{

}