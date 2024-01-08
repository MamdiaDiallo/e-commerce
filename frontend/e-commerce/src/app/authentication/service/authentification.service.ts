import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { User } from 'src/app/users/models/User';
import { UserResponse } from 'src/app/users/service/user-response';
import { UserResponseMapper } from 'src/app/users/service/user-response.mapper';

export type AuthenticatedState = {
  type: 'authenticated';
  user: User;
};

export type NonAuthenticatedState = {
  type: 'anonymous';
};

export type AuthenticationState = AuthenticatedState | NonAuthenticatedState;

@Injectable({ providedIn: 'root' })
export class AuthentificationService {
  private readonly authUrl = 'http://localhost:4000/auth/state';

  get authState$(): Observable<AuthenticationState> {
    return this._authState$;
  }

  private readonly _authState$ = new BehaviorSubject<AuthenticationState>({
    type: 'anonymous',
  });

  constructor(
    private readonly http: HttpClient,
    private readonly userResponseMapper: UserResponseMapper
  ) {}

  loadState(): Observable<void> {
    return this.http
      .get<UserResponse>(this.authUrl, {
        observe: 'response',
      })
      .pipe(
        tap((response) => {
          switch (response.status) {
            case HttpStatusCode.NoContent:
              this._authState$.next({ type: 'anonymous' });
              break;
            case HttpStatusCode.Ok:
              const user = this.userResponseMapper.map(response.body!);
              this._authState$.next({ type: 'authenticated', user });
              break;
            default:
              throw Error(`Fetch authState failed (${response.status})`);
          }
        }),
        map((_response) => undefined)
      );
  }
  authenticate(email: string, password: string): Observable<void> {
    return this.http
      .post<void>(this.authUrl, undefined, {
        observe: 'response',
        headers: {
          Authorization: `Basic ${btoa(email + ':' + password)}`,
        },
      })
      .pipe(
        tap((response) => {
          switch (response.status) {
            case HttpStatusCode.Unauthorized:
              throw Error('Bad credential');
            case HttpStatusCode.Ok:
              const user = this.userResponseMapper.map(response.body!);
              this._authState$.next({ type: 'authenticated', user });
              break;
            default:
              throw Error(`authentication failed(${response.status})`);
          }
        }),
        map((_response) => undefined)
      );
  }

  logout(): Observable<void> {
    return this.http
      .get<void>(`${this.authUrl}/logout`, {
        observe: 'response',
      })
      .pipe(
        tap((response) => {
          switch (response.status) {
            case HttpStatusCode.NoContent:
              this._authState$.next({ type: 'anonymous' });
              break;
            default:
              throw Error(`logout failed (${response.status})`);
          }
        }),
        map((_response) => undefined)
      );
  }
}
