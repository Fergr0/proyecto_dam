import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstalacionService {

  private apiUrl = 'http://localhost:8080/api/instalaciones'; // URL de tu backend

  constructor(private http: HttpClient) {}

  // Obtener todas las instalaciones
  getAllInstalaciones(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`);
  }

  // Buscar instalaciones por nombre
  findByNombre(nombre: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/buscar/nombre/${nombre}`);
  }
}
