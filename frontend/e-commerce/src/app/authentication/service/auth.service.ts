import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class authservice {
    private token = 'MyFakeToken';

    getToken(): string {
        return this.token;
    }
}