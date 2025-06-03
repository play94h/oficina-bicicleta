import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080'; 
  
  constructor(private http: HttpClient) {}

  login(dados: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/usuarios/login`, dados); 
  }

  register(dados: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/usuarios`, dados);
  }

  cadastrarCliente(cliente: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/cliente`, cliente);
  }
}
