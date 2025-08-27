package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.MetodoPago;
import org.carpio.aerlyapi.model.dto.MetodoPagoDto;

import java.util.List;

public interface MetodoPagoService {
    List<MetodoPagoDto> getAllMetodoPagos();
    MetodoPagoDto getMetodoPagoById(Long id);
    MetodoPagoDto createMetodoPago(MetodoPago metodoPago);
    MetodoPagoDto updateMetodoPago(Long id, MetodoPago metodoPago);
    void deleteMetodoPago(Long id);
}
