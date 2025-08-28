import Pais from "./pais";

export default interface Estado {
    id: number;
    nombre: string;
    pais: Pais;
}
