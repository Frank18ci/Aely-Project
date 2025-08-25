package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.dto.RolDto;
import org.carpio.aerlyapi.model.utils.RolMapper;
import org.carpio.aerlyapi.repository.RolRepository;
import org.carpio.aerlyapi.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    @Override
    public List<RolDto> getAllRoles() {
        return RolMapper.toDtoList(rolRepository.findAll());
    }

    @Override
    public RolDto getRolById(Long id) {
        return RolMapper.toDto(rolRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Rol no encontrado con id: " + id)
        ));
    }

    @Override
    public RolDto createRol(Rol rol) {
        return RolMapper.toDto(rolRepository.save(rol));
    }

    @Override
    public RolDto updateRol(Long id, Rol rol) {
        Rol rollFound = rolRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Rol no encontrado con id: " + id)
        );
        rollFound.setNombre(rol.getNombre() != null ? rol.getNombre() : rollFound.getNombre());

        return RolMapper.toDto(rolRepository.save(rollFound));
    }

    @Override
    public void deleteRol(Long id) {
        Rol rolFound = rolRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Rol no encontrado con id: " + id)
        );
        rolRepository.delete(rolFound);
    }
}
