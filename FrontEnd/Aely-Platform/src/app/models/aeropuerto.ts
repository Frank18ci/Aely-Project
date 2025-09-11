import Estado from "./estado";
import Idioma from "./idioma";

export default interface Aeropuerto {
    id: number;
    nombre: string;
    codigoIata: string;
    ubicacion: string;
    direccion: string;
    estado: boolean;
    estadoAeropuerto: Estado;
    idioma: Idioma;
}
