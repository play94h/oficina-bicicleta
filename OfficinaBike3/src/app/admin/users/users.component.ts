import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from '../user.service';
import { RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-users',
  templateUrl: './users.component.html',
  imports: [CommonModule, RouterModule]
})
export class UsersComponent implements OnInit {
  usuarios: any[] = [];
  isAdmin: boolean = false;

  constructor(private userService: UserService) {}

  ngOnInit() {
    const role = localStorage.getItem('role');
    this.isAdmin = role === 'ADMIN';

    this.userService.listar().subscribe({
      next: (res) => (this.usuarios = res),
      error: (err) => console.error(err)
    });
  }

  excluir(id: number) {
    if (confirm('Tem certeza que deseja excluir este usuário?')) {
      this.userService.deletar(id).subscribe(() => {
        this.usuarios = this.usuarios.filter(u => u.id !== id);
      });
    }
  }

  editar(usuario: any) {
    alert(`Editar usuário: ${usuario.username}`);
  }
}
