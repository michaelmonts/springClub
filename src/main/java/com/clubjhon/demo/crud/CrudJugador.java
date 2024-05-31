package com.clubjhon.demo.crud;


import org.springframework.data.repository.CrudRepository;

import com.clubjhon.demo.variables.Jugador;

public interface CrudJugador extends CrudRepository<Jugador, Integer>{

}