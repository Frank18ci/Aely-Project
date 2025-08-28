import Aerolinea from "./aerolinea";
import ModeloAvion from "./modelo-avion";

export default interface Avion {
    id: number;
    modeloAvion: ModeloAvion;
    aerolinea: Aerolinea;
    
}
