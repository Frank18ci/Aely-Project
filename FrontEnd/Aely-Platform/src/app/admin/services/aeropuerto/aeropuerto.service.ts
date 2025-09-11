import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import API_URL from '../values/api';
import Aeropuerto from '../../../models/aeropuerto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AeropuertoService {

  constructor(private http: HttpClient) {

  }
  getAeropuertos() : Observable<Aeropuerto[]> {
    return this.http.get<Aeropuerto[]>(`${API_URL}/aeropuertos`);
  }
  getAeropuertoById(id: number) : Observable<Aeropuerto> {
    return this.http.get<Aeropuerto>(`${API_URL}/aeropuertos/${id}`);
  }
  createAeropuerto(aeropuerto: Aeropuerto) : Observable<Aeropuerto> {
    return this.http.post<Aeropuerto>(`${API_URL}/aeropuertos`, aeropuerto);
  }
  updateAeropuerto(id: number, aeropuerto: Aeropuerto) : Observable<Aeropuerto> {
    return this.http.put<Aeropuerto>(`${API_URL}/aeropuertos/${id}`, aeropuerto);
  }
  deleteAeropuerto(id: number) : Observable<void> {
    return this.http.delete<void>(`${API_URL}/aeropuertos/${id}`);
  }
}
