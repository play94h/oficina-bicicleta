import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './componets/login/login.component';
import { UserRegisterComponent } from './componets/registro/registro.component';
import { HomeComponent } from './componets/home/home.component';
import { UserListComponent } from './admin/users/users.component';
import { ClienteRegisterComponent } from './componets/cliente-register/cliente-register.component';
import { ProdutoRegisterComponent } from './componets/produto-register/produto-register.component';
import { AuthGuard } from './componets/guards/auth.guard';


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: UserRegisterComponent },

  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cadastro-cliente',
    component: ClienteRegisterComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cadastro-produto',
    component: ProdutoRegisterComponent,
    canActivate: [AuthGuard]
  },
    {
    path: 'admin/usuarios',
    component: UserListComponent,
    canActivate: [AuthGuard] // se quiser acesso somente a admins
  },

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' }
];


