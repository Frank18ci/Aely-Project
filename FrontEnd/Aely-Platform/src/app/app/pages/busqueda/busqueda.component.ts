import { Component } from '@angular/core';
import { DataPickerComponent } from "../../components/data-picker/data-picker.component";
import { DestinosComponent } from "../../components/card/destinos/destinos.component";
import { BuscarVuelosComponent } from "../../components/search/buscar-vuelos/buscar-vuelos.component";
@Component({
  selector: 'app-busqueda',
  imports: [DestinosComponent, BuscarVuelosComponent],
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {

}
