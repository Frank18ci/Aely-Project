import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AeropuertoService {
    constructor(private http: HttpClient){

    }
    getAeropuertos() {
        return this.http.get(`${environment.apiUrl}/aeropuertos`);
    }
}
