package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.dto.RolDto;

import java.util.List;

public interface RolService {
    List<RolDto> getAllRoles();
    RolDto getRolById(Long id);
    RolDto createRol(Rol rol);
    RolDto updateRol(Long id, Rol rol);
    void deleteRol(Long id);
}
