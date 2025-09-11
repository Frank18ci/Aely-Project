import { Component } from '@angular/core';
import { AeropuertoService } from '../../services/aeropuerto/aeropuerto.service';
import Aeropuerto from '../../../models/aeropuerto';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-aeropuerto-page',
  imports: [NgClass],
  templateUrl: './aeropuerto-page.component.html',
  styleUrl: './aeropuerto-page.component.css',
})
export class AeropuertoPageComponent {
  aeropuertos: Aeropuerto[] = [];
  openCreateModal() {
    // Logic to open the modal for creating a new airport
    console.log('Open create airport modal');
  }
  constructor(private aeropuertoService: AeropuertoService) {

  }
  ngOnInit() {
    this.aeropuertoService.getAeropuertos().subscribe((data) => {
      this.aeropuertos = data;
      console.log(this.aeropuertos);
    });
  }
}
