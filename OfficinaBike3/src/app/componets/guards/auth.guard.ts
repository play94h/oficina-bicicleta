import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';

export const AuthGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const role = localStorage.getItem('usuarioRole');

  if (role === 'ADM' || role === 'cliente') {
    return true;
  }

  router.navigate(['/login']);
  return false;
};
