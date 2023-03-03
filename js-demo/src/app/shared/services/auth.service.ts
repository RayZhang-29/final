import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment.development";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: object | null = null;

  constructor(
    private httpClient: HttpClient
  ) {
    // this.checkLogin()
    //   .subscribe(res => {
    //     res.success ? this.user = res.user : this.user = null;
    //   })
  }

  // checkLogin(): Observable<{success: boolean, user: object}> {
  //   return this.httpClient.get<{success: boolean, user: object}>(
  //     `${environment.api_url}/checklogin`,
  //     {withCredentials: true}
  //   );
  // }
  //
  // logout(): Observable<{success: boolean}> {
  //   return this.httpClient.get<{success: boolean}>(
  //     `${environment.api_url}/logout`,
  //     {withCredentials: true}
  //   );
  // }

  login(user: {username: string, password: string}): Observable<{success: boolean, user: object}> {
    // login is a post req
    // spring security takes form data
    // need to use HttpParams to convert json to form data.
    // const userFormData = new HttpParams()
    //   .append('username', )
    return this.httpClient.post<{success: boolean, user: object}>(
      `${environment.api_url}/login`,
      user,
      // {withCredentials: true}
    );
  }
}
