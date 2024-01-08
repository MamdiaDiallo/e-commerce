import { Component } from '@angular/core';
import { Observable, map } from 'rxjs';
import { User } from './users/models/User';
import { AuthentificationService } from './authentication/service/authentification.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  template: `
    <div class="container">
    <form [formGroup]="form" (ngSubmit)="authenticate()">
      <label>Email</label>
      <input type="text" placeholder="email" formControlName="email">

      <label>password</label>
      <input type="password" formControlName="password">
      <button type="submit">connection</button>
    </form>
   </div>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  form!: FormGroup
  
  error!: Error

  constructor(private authentificationService: AuthentificationService,
     private formBuilder: FormBuilder,
     private router: Router) {
 
  }

  ngOnInit():void {
    this.form = this.formBuilder.group({
      email: this.formBuilder.control(''),
      password: this.formBuilder.control('')
    })
  }
  authenticate(): void {
    console.log("authenticate ",this.form.value)

    const {email , password } = this.form.value
    this.authentificationService.authenticate(email, password)
    .subscribe({
      next:() => {
        this.router.navigateByUrl('login')
      },
      error: err => {
        this.error = err
      }
    })
  }
}
