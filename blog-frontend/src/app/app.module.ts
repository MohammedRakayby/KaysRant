import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';
import { LoggingInterceptor } from './http-interceptors/logging-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    TimelineComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
