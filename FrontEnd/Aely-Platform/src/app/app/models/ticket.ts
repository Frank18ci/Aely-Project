import Asiento from "./asiento";
import Reserva from "./reserva";

export default interface Ticket {
  id: number;
  reserva: Reserva;
  asiento: Asiento;
  codigoTicket: string;
  fechaEmision: Date;
}
