import Aeropuerto from "./aeropuerto";
import Avion from "./avion";

export default interface Vuelo {
    id: number;
    codigoVuelo: string;
    origen: Aeropuerto;
    destino: Aeropuerto;
    fechaSalida: Date;
    fechaLlegada: Date;
    duracion: number;
    estado: boolean;
    avion: Avion;
}