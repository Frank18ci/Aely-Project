package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.EstadoPago;
import org.carpio.aerlyapi.model.dto.EstadoPagoDto;

import java.util.List;

public interface EstadoPagoService {
    List<EstadoPagoDto> getAllEstadoPagos();
    EstadoPagoDto getEstadoPagoById(Long id);
    EstadoPagoDto createEstadoPago(EstadoPago estadoPago);
    EstadoPagoDto updateEstadoPago(Long id, EstadoPago estadoPago);
    void deleteEstadoPago(Long id);
}
