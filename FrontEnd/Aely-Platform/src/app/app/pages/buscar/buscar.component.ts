import { Component } from '@angular/core';
import { DataPickerComponent } from "../../components/data-picker/data-picker.component";
import { BuscarVuelosComponent } from "../../components/search/buscar-vuelos/buscar-vuelos.component";
import { CardVueloComponent } from "../../components/card/card-vuelo/card-vuelo.component";

@Component({
  selector: 'app-buscar',
  imports: [BuscarVuelosComponent, CardVueloComponent],
  templateUrl: './buscar.component.html',
  styleUrl: './buscar.component.css'
})
export class BuscarComponent {

}
