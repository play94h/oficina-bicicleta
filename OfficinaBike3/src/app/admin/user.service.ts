import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private api = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) {}

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.api);
  }

  editar(usuarios: any): Observable<any> {
    return this.http.put(`${this.api}/${usuarios.id}`, usuarios);
  }

  deletar(id: number): Observable<any> {
    return this.http.delete(`${this.api}/${id}`);
  }
}
