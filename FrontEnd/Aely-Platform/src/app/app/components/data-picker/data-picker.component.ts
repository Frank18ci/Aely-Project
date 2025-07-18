import { ChangeDetectionStrategy, Component } from '@angular/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {provideNativeDateAdapter} from '@angular/material/core';


@Component({
  selector: 'app-data-picker',
  providers: [provideNativeDateAdapter()],
  imports: [MatDatepickerModule, MatInputModule, MatFormFieldModule],
  templateUrl: './data-picker.component.html',
  styleUrl: './data-picker.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DataPickerComponent {

}
