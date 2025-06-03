
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto-register/produto-service/produto.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule], 
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  nomeUsuario = 'Usuário';
  isAdmin: boolean = false;
  produtos: any[] = [];

  constructor(private router: Router, private produtoService: ProdutoService) {}

  irParaCadastroCliente() {
    this.router.navigate(['/cadastro-cliente']);
  }

  irParaCadastroProduto() {
    this.router.navigate(['/cadastro-produto']);
  }
  irParaListarUsuarios(){
    this.router.navigate(['/admin/usuarios']);
  }
  
    ngOnInit() {

    this.nomeUsuario = localStorage.getItem('username') || 'Usuário';
    const role = localStorage.getItem('usuarioRole');
    this.isAdmin = role === 'ADM';
    this.carregarProdutos();

  }

  carregarProdutos() {
    this.produtoService.listarProdutos().subscribe({
      next: (res) => this.produtos = res,
      error: (err) => console.error('Erro ao carregar produtos:', err)
    });
  }

  logout() {
  localStorage.clear();
  this.router.navigate(['/login']);
  }

}
