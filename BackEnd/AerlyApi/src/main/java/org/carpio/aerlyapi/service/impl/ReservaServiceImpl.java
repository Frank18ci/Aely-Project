package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.model.dto.ReservaDto;
import org.carpio.aerlyapi.model.utils.ReservaMapper;
import org.carpio.aerlyapi.repository.ReservaRepository;
import org.carpio.aerlyapi.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;

    @Override
    public List<ReservaDto> getAllReservas() {
        return ReservaMapper.toDtoList(reservaRepository.findAll());
    }

    @Override
    public ReservaDto getReservaById(Long id) {
        return ReservaMapper.toDto(reservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Reserva not found with id: " + id)
        ));
    }

    @Override
    public ReservaDto createReserva(Reserva reserva) {
        return ReservaMapper.toDto(reservaRepository.save(reserva));
    }

    @Override
    public ReservaDto updateReserva(Long id, Reserva reserva) {
        Reserva reservaFound = reservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Reserva not found with id: " + id)
        );
        reservaFound.setUsuario(reserva.getUsuario());
        reservaFound.setFechaReserva(reserva.getFechaReserva());
        reservaFound.setEstadoReserva(reserva.getEstadoReserva());

        return ReservaMapper.toDto(reservaRepository.save(reservaFound));
    }

    @Override
    public void deleteReserva(Long id) {
        Reserva reservaFound = reservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Reserva not found with id: " + id)
        );
        reservaRepository.delete(reservaFound);
    }
}
