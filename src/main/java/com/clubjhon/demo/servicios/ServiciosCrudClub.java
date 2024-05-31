package com.clubjhon.demo.servicios;
import com.clubjhon.demo.variables.Club;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudClub extends JpaRepository<Club, Integer> {
}