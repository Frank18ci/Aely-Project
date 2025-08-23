package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.EstadoAsiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAsientoRepository extends JpaRepository<EstadoAsiento, Long> {
}
