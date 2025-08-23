package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
