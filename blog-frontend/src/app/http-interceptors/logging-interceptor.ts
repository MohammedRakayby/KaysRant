import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';

import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

/** Pass untouched request through to the next request handler. */
@Injectable()
export class LoggingInterceptor implements HttpInterceptor {

    constructor() {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        console.log("outgoing request", request);
        request = request.clone({
            withCredentials: true
        });
        console.log("new outgoing request", request);

        return next
            .handle(request)
            .pipe(tap((ev: HttpEvent<any>) => {
                console.log("got an event", ev)
                if (ev instanceof HttpResponse) {
                    console.log('event of type response', ev);
                }
            }));
    }
}