package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Long> {
}
