import { Component } from '@angular/core';
import { DataPickerComponent } from "../../data-picker/data-picker.component";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-buscar-vuelos',
  imports: [DataPickerComponent, RouterLink],
  templateUrl: './buscar-vuelos.component.html',
  styleUrl: './buscar-vuelos.component.css'
})
export class BuscarVuelosComponent {

}
