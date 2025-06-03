import { TestBed } from '@angular/core/testing';
import { CanActivateFn, Router } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { RouterTestingModule } from '@angular/router/testing';

describe('AuthGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) =>
    TestBed.runInInjectionContext(() => AuthGuard(...guardParameters));

  let router: Router;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule]
    });

    router = TestBed.inject(Router);
    spyOn(router, 'navigate'); // intercepta redirecionamentos
  });

  it('deve permitir acesso se usuário estiver logado', () => {
    localStorage.setItem('usuarioRole', 'ADM');

    const result = executeGuard({} as any, {} as any);
    expect(result).toBeTrue();
  });

  it('deve bloquear acesso se usuário não estiver logado', () => {
    localStorage.removeItem('usuarioRole');

    const result = executeGuard({} as any, {} as any);
    expect(result).toBeFalse();
    expect(router.navigate).toHaveBeenCalledWith(['/login']);
  });
});
