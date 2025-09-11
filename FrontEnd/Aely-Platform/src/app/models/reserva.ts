import EstadoReserva from "./estado-reserva";
import Usuario from "./usuario";

export default interface Reserva {
  id: number;
  usuario: Usuario;
  fechaReserva: Date;
  estadoReserva: EstadoReserva;
}
