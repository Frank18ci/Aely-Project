import { Component } from '@angular/core';
import { DataPickerComponent } from "../../components/data-picker/data-picker.component";
import { DestinosComponent } from "../../components/card/destinos/destinos.component";
@Component({
  selector: 'app-busqueda',
  imports: [DataPickerComponent, DestinosComponent],
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {

}
