import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './componets/login/login.component';
import { RegistroComponent } from './componets/registro/registro.component';
import { HomeComponent } from './componets/home/home.component';
import { UsersComponent } from './admin/users/users.component';

export const routes: Routes = [
    
    
    {
    path:"",
    component: LoginComponent
    },
    {

    path:"registro",
    component: RegistroComponent
    },
    {
        path:"usuario",
        component: UsersComponent

    }




];
