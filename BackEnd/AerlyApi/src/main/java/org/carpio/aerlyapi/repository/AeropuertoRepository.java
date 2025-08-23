package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
}
