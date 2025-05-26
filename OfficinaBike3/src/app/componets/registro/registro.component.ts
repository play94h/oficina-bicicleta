import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  standalone: true,
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrl:'./registro.component.css',
  imports: [CommonModule, ReactiveFormsModule],
})
export class RegistroComponent {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.registerForm = this.fb.group({
      username: [''],
      password: ['']
    });
  }

  onSubmit() {
    this.authService.register(this.registerForm.value).subscribe({
      next: () => {
        alert('Cadastro realizado com sucesso!');
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error(err);
        alert('Erro no cadastro');
      }
    });
  }
}
