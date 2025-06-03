import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UserListComponent implements OnInit {
  usuarios: any[] = [];
  isAdmin: boolean = false;
  loggedUserId: string | null = null;

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit() {
    const role = localStorage.getItem('usuarioRole');
    this.isAdmin = role === 'ADM';
    this.loggedUserId = localStorage.getItem('usuarioId');

    if (this.isAdmin) {
      this.loadAllUsers();
    } else if (this.loggedUserId) {
      this.loadSingleUser(+this.loggedUserId);
    }
  }

  loadAllUsers() {
    this.userService.listar().subscribe({
      next: (res) => this.usuarios = res,
      error: (err) => console.error('Erro ao carregar usuários:', err)
    });
  }

  loadSingleUser(id: number) {
    this.userService.buscarPorId(id).subscribe({
      next: (res) => this.usuarios = [res],
      error: (err) => console.error('Erro ao carregar usuário:', err)
    });
  }

  editar(usuario: any) {
    // Redireciona para a tela de edição, por exemplo:
    this.router.navigate(['/editar-usuario', usuario.usuarioId]);
  }

  excluir(id: number) {
    if (!this.isAdmin) return;
    if (confirm('Tem certeza que deseja excluir este usuário?')) {
      this.userService.deletar(id).subscribe({
        next: () => this.usuarios = this.usuarios.filter(u => u.usuarioId !== id),
        error: (err) => console.error('Erro ao excluir usuário:', err)
      });
    }
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }
}
