package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Long> {
}
