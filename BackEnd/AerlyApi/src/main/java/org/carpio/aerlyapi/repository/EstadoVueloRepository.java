package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.EstadoVuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVueloRepository extends JpaRepository<EstadoVuelo, Long> {
}
