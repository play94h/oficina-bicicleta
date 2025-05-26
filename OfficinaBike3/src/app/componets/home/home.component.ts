import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-home',
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  nomeUsuario: string = 'Usuário';

  constructor(private router: Router) {}

  ngOnInit(): void {
    const nome = localStorage.getItem('nome') || localStorage.getItem('username');
    if (nome) {
      this.nomeUsuario = nome;
    }
  }

  irParaCompras() {
    this.router.navigate(['/user/compras']);
  }

  irParaManutencao() {
    this.router.navigate(['/user/manutencao']);
  }
}
