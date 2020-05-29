import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TimelineComponent } from './timeline/timeline.component'
import { EditorComponent } from './editor/editor.component'
import { LoginComponent } from './login/login.component';

const routes: Routes = [

  { path: 'timeline', component: TimelineComponent },
  { path: 'editor', component: EditorComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/timeline', pathMatch: 'full' },
  { path: '**', component: TimelineComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
