import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';
import { LoggingInterceptor } from './http-interceptors/logging-interceptor';
import { EditorComponent } from './editor/editor.component';
import { AppRoutingModule } from './app-routing.module';
import { SinglePostComponent } from './timeline/single-post/single-post.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelineComponent,
    EditorComponent,
    SinglePostComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
