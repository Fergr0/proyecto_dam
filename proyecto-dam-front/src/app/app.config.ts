import { importProvidersFrom, ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './AuthInterceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    importProvidersFrom(HttpClientModule, ReactiveFormsModule),  // Importa módulos necesarios
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,  // Usa el interceptor para manejar el token
      multi: true                // Indica que puede haber múltiples interceptores
    }
  ]
};
