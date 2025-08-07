import { Component } from '@angular/core';

@Component({
  selector: 'app-aeropuerto-page',
  imports: [],
  templateUrl: './aeropuerto-page.component.html',
  styleUrl: './aeropuerto-page.component.css',
})
export class AeropuertoPageComponent {
  openCreateModal() {
    // Logic to open the modal for creating a new airport
    console.log('Open create airport modal');
  }
}
