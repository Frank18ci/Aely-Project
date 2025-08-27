package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Pago;
import org.carpio.aerlyapi.model.dto.PagoDto;

import java.util.List;

public interface PagoService {
    List<PagoDto> getAllPagos();
    PagoDto getPagoById(Long id);
    PagoDto createPago(Pago pago);
    PagoDto updatePago(Long id, Pago pago);
    void deletePago(Long id);
}
