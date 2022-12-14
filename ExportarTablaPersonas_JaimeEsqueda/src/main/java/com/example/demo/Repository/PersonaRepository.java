package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Integer>{

}
