package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.MetodoPago;
import org.carpio.aerlyapi.model.dto.MetodoPagoDto;
import org.carpio.aerlyapi.model.utils.MetodoPagoMapper;
import org.carpio.aerlyapi.repository.MetodoPagoRepository;
import org.carpio.aerlyapi.service.MetodoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl implements MetodoPagoService {
    private final MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPagoDto> getAllMetodoPagos() {
        return MetodoPagoMapper.toDtoList(metodoPagoRepository.findAll());
    }

    @Override
    public MetodoPagoDto getMetodoPagoById(Long id) {
        return MetodoPagoMapper.toDto(metodoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Metodo de pago no encontrado con id: " + id)
        ));
    }

    @Override
    public MetodoPagoDto createMetodoPago(MetodoPago metodoPago) {
        return MetodoPagoMapper.toDto(metodoPagoRepository.save(metodoPago));
    }

    @Override
    public MetodoPagoDto updateMetodoPago(Long id, MetodoPago metodoPago) {
        MetodoPago metodoPagoFound = metodoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Metodo de pago no encontrado con id: " + id)
        );
        metodoPagoFound.setMetodo(metodoPago.getMetodo());

        return MetodoPagoMapper.toDto(metodoPagoRepository.save(metodoPagoFound));
    }

    @Override
    public void deleteMetodoPago(Long id) {
        MetodoPago metodoPagoFound = metodoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Metodo de pago no encontrado con id: " + id)
        );
        metodoPagoRepository.delete(metodoPagoFound);
    }
}
