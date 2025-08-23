package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.ClaseAsiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseAsientoRepository extends JpaRepository<ClaseAsiento, Long> {
}
