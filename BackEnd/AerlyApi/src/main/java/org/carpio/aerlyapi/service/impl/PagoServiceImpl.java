package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Pago;
import org.carpio.aerlyapi.model.dto.PagoDto;
import org.carpio.aerlyapi.model.utils.PagoMapper;
import org.carpio.aerlyapi.repository.PagoRepository;
import org.carpio.aerlyapi.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;

    @Override
    public List<PagoDto> getAllPagos() {
        return PagoMapper.toDtoList(pagoRepository.findAll());
    }

    @Override
    public PagoDto getPagoById(Long id) {
        return PagoMapper.toDto(pagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pago not found with id: " + id)
        ));
    }

    @Override
    public PagoDto createPago(Pago pago) {
        return PagoMapper.toDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto updatePago(Long id, Pago pago) {
        Pago pagoFound = pagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pago not found with id: " + id)
        );
        pagoFound.setReserva(pago.getReserva());
        pagoFound.setMonto(pago.getMonto());
        pagoFound.setMoneda(pago.getMoneda());
        pagoFound.setMetodoPago(pago.getMetodoPago());
        pagoFound.setFechaPago(pago.getFechaPago());
        pagoFound.setEstadoPago(pago.getEstadoPago());

        return PagoMapper.toDto(pagoRepository.save(pagoFound));
    }

    @Override
    public void deletePago(Long id) {
        Pago pagoFound = pagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pago not found with id: " + id)
        );
        pagoRepository.delete(pagoFound);
    }
}
