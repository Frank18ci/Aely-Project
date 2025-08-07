import { Component, Input } from '@angular/core';
import Destino from '../../../models/destino';

@Component({
  selector: 'app-destinos',
  imports: [],
  templateUrl: './destinos.component.html',
  styleUrl: './destinos.component.css'
})
export class DestinosComponent {
  @Input() destino: Destino = {
    id: 0,
    nombre: '',
    pais: '',
    descripcion: '',
    imagen: ''
  };
}
