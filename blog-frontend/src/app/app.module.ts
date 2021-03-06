import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoggingInterceptor } from './http-interceptors/logging-interceptor';
import { EditorComponent } from './editor/editor.component';
import { AppRoutingModule } from './app-routing.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button'
import { MatDialogModule } from '@angular/material/dialog';
import { QuillModule } from 'ngx-quill';
import { PreviewComponent } from './editor/preview/preview.component';
import { SinglepostComponent } from './singlepost/singlepost.component'

@NgModule({
  declarations: [
    AppComponent,
    TimelineComponent,
    EditorComponent,
    LoginComponent,
    PreviewComponent,
    SinglepostComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    QuillModule.forRoot()
  ],
  entryComponents: [
    PreviewComponent
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
