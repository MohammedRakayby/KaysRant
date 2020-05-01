import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private host = "http://localhost:8080";
  constructor(private http: HttpClient) { }
  //later
  // handle errors
  getData(url: string, options?) {
    //later: check for options parameter
    if (options) {
      return this.http.get(this.host + url, options);
    }
    return this.http.get(this.host + url, { headers: { 'Content-Type': 'application/json' } });
  }
}
