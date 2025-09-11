import Idioma from "./idioma";
import Pais from "./pais";
import Rol from "./rol";

export default interface Usuario {
  id: number;
  correoElectronico: string;
  password: string;
  nombres: string;
  apellidos: string;
  fechaNacimiento: Date;
  fechaRegistro: Date;
  estado: boolean;
  pais: Pais;
  idioma: Idioma;
  rol: Rol;
}
