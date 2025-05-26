import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  standalone: true,
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  imports: [CommonModule, ReactiveFormsModule],
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      username: [''],
      password: ['']
    });
  }

  onSubmit() {
    this.authService.login(this.loginForm.value).subscribe({
      next: (res) => {
        console.log('Login realizado:', res);
        localStorage.setItem('token', res.token);
        this.router.navigate(['/home']);
      },
      error: (err) => {
        console.error('Erro no login:', err);
        alert('usuario ou senha inválidos');
      }
    });
  }
}
