import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './authentication/components/login/login.component';
import { AuthentificationService } from './authentication/service/authentification.service';
import { WithCredentialsInterceptor } from './authentication/interceptors/with-credentials.interceptor';
import { UserResponseMapper } from './users/service/user-response.mapper';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './authentication/interceptors/auth.interceptor';


@NgModule({
  declarations: [AppComponent, LoginComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
   /* [UserResponseMapper, AuthentificationService],
    {
      provide: APP_INITIALIZER,
      useFactory: (authservice: AuthentificationService) => () =>
        authservice.loadState(),
      multi: true,
      deps: [AuthentificationService],
    },
    {
      provide: HTTP_INTERCEPTORS,
      multi: true,
      useClass: WithCredentialsInterceptor,
    },
  */],
  bootstrap: [AppComponent],
})
export class AppModule { }
