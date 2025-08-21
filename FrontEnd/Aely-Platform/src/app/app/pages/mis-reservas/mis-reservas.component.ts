import { Component } from '@angular/core';
import { DataPickerAerlyComponent } from '../../components/data-picker-aerly/data-picker-aerly.component';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { CardReservaComponent } from '../../components/card/card-reserva/card-reserva.component';


@Component({
  selector: 'app-mis-reservas',
  imports: [DataPickerAerlyComponent, FormsModule, MatFormFieldModule, MatInputModule, CardReservaComponent],
  templateUrl: './mis-reservas.component.html',
  styleUrl: './mis-reservas.component.css'
})
export class MisReservasComponent {

}
