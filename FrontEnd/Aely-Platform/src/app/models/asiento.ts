import ClaseAsiento from "./clase-asiento";
import EstadoAsiento from "./estado-asiento";
import Vuelo from "./vuelo";

export default interface Asiento {
    id: number;
    numeroAsiento: string;
    vuelo: Vuelo;
    claseAsiento: ClaseAsiento;
    estadoAsiento: EstadoAsiento;
}