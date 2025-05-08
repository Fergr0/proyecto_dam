import { Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ProtectedComponent } from './protected/protected.component';
import { authGuard } from './auth/auth.guard';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'protegido', component: ProtectedComponent, canActivate: [authGuard] },
    { path: '**', redirectTo: 'login' }
  ];
