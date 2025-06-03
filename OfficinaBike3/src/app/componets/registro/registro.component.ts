import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-user-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule, RouterModule],
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class UserRegisterComponent {
  userForm: FormGroup;
  
  
  cargos: string[] = ['ADM', 'funcionario', 'cliente', 'tecnico']; 

  constructor(
    private fb: FormBuilder,
    private AuthService: AuthService,
    private router: Router
  ) {
    this.userForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(25)]],
      cargousuario: ['cliente', Validators.required] 
    });
  }

  onSubmit() {
    if (this.userForm.valid) {
      const novoUsuario = {
        username: this.userForm.value.username,
        password: this.userForm.value.password,
        cargousuario: this.userForm.value.cargousuario
      };

      this.AuthService.register(novoUsuario).subscribe({
        next: () => {
          alert('Usuário cadastrado com sucesso!');
          this.userForm.reset({ cargousuario: 'cliente' });
          this.router.navigate(['/admin/usuarios']); // ou outra rota
        },
        error: (err) => {
          console.error(err);
          alert('Erro ao cadastrar usuário!');
        }
      });
    } else {
      alert('Preencha todos os campos corretamente.');
    }
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }
}
