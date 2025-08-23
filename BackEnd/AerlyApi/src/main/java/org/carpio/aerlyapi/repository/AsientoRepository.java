package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {
}
