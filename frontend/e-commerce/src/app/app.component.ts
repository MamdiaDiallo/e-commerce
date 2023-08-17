import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
   <p>Welcome Mamdia Shop</p>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'e-commerce';
}
