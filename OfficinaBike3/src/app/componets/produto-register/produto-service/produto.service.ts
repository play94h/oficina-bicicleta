import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProdutoService {
  private apiUrl = 'http://localhost:8080/produtos/salvarproduto';

  constructor(private http: HttpClient) {}

  cadastrarProduto(produto: any): Observable<any> {
    return this.http.post(this.apiUrl, produto);
  }
  listarProdutos() {
  return this.http.get<any[]>('http://localhost:8080/produtos');
}
}
