import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.authService.login(this.loginForm.value).subscribe({
        next: (response: any) => {
          // Ajuste conforme o JSON real retornado pelo backend
          localStorage.setItem('username', response.username);
          localStorage.setItem('uusuarioId', response.usuarioId.toString());
          localStorage.setItem('usuarioRole', response.cargousuario); 

          this.router.navigate(['/home']);
        },
        error: (err) => {
          alert('Login inválido');
          console.error(err);
        }
      });
    }
  }

  irParaCadastro() {
    this.router.navigate(['/register']);
  }
}
