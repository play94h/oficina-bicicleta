import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoService } from './produto-service/produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produto-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './produto-register.component.html',
  styleUrls: ['./produto-register.component.css']
})
export class ProdutoRegisterComponent {
  produtoForm: FormGroup;

  grupos: string[] = ['Pneu', 'Guidôes', 'Quadros', 'Freios', 'Combios_e_Marchas', 'Cubos', 'Correntes',' Monoplas','Mesas', 'Cãmarã_de_Ar', 'Raios'
	,'Rodas','Pedais_e_Pedivelas', 'Bancos_E_Selins', 'Canotes,Aros',]; // Exemplo de valores do Enum

  constructor(private fb: FormBuilder, private produtoService: ProdutoService, private router: Router) {
    this.produtoForm = this.fb.group({
      nome: ['', Validators.required],
      preco: [null, Validators.required],
      quantidadeEstoque: [0, Validators.required],
      desquicao: [''],
      marca: [''],
      grupoproduto: ['', Validators.required]
    });
  }
  voltarHome() {
  this.router.navigate(['/home']);
}

  onSubmit() {
    if (this.produtoForm.valid) {
      this.produtoService.cadastrarProduto(this.produtoForm.value).subscribe({
        next: () => {
          alert('Produto cadastrado com sucesso!');
          this.produtoForm.reset();
        },
        error: (err) => {
          console.error(err);
          alert('Erro ao cadastrar produto!');
        }
      });
    }
  }
}
