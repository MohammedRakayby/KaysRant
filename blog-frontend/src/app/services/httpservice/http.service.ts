import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private host = "http://localhost:8080";
  constructor(private http: HttpClient) { }
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

  
  login(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('user', {headers: headers}).subscribe(response => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });

}
}
