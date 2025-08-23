package org.carpio.aerlyapi.repository;

import org.carpio.aerlyapi.model.ModeloAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloAvionRepository extends JpaRepository<ModeloAvion, Long> {
}
