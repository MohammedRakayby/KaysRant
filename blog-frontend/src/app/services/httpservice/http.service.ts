import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { User } from 'src/app/models/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private host = "http://localhost:8080";
  constructor(private http: HttpClient, private router: Router) { }
  //later
  authenticated = false;
  // handle errors
  getData(url: string, options?) {
    //later: check for options parameter
    if (options) {
      return this.http.get(this.host + url, options);
    }
    return this.http.get(this.host + url, { headers: { 'Content-Type': 'application/json' } });
  }


  login(email, password) {
    return this.http.post(this.host + '/auth/login', { "username": email, "password": password }).subscribe((res: any) => {
      debugger;
      if (res.status == 200) {
        console.log("User is logged in");
        this.router.navigateByUrl('/');
      } else {
        console.log("login failed");
      }
    });;
  }

}
