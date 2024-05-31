package com.clubjhon.demo.crud;


import org.springframework.data.repository.CrudRepository;

import com.clubjhon.demo.variables.Club;

public interface CrudClub extends CrudRepository<Club, Integer>{

}