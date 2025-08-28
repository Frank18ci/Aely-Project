import EstadoPago from "./estado-pago";
import MetodoPago from "./metodo-pago";
import Reserva from "./reserva";

export default interface Pago {
  id: number;
  reserva: Reserva;
  monto: number;
  moneda: string;
  metodoPago: MetodoPago;
  fechaPago: Date;
  estadoPago: EstadoPago;
}
