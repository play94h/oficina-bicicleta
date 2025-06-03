import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClienteService } from './cliente-service/cliente.service'
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './cliente-register.component.html',
  styleUrls: ['./cliente-register.component.css'] // <-- aqui
})
export class ClienteRegisterComponent {
  clienteForm: FormGroup;

  constructor(private fb: FormBuilder, private clienteService: ClienteService ,private router: Router) {
    this.clienteForm = this.fb.group({
      nome: ['', Validators.required],
      cpf: ['', [Validators.required, Validators.minLength(11)]],
      telefone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      
    });
  }
  
  voltarHome() {
  this.router.navigate(['/home']);
}

  onSubmit() {
    if (this.clienteForm.valid) {
      this.clienteService.cadastrarCliente(this.clienteForm.value).subscribe({
        next: () => {
          alert('Cliente cadastrado com sucesso!');
          this.clienteForm.reset();
        },
        error: (err) => {
          console.error(err);
          alert('Erro ao cadastrar cliente!');
        }
      });
    }
  }
}
