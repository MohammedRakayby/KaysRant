import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TimelineComponent } from './timeline/timeline.component'
import { EditorComponent } from './editor/editor.component'
import { LoginComponent } from './login/login.component';
import { LoggedAdminGuard } from './guards/logged-admin.guard';
import { AnonymousGuard } from './guards/anonymous.guard';
import { SinglepostComponent } from './singlepost/singlepost.component';

const routes: Routes = [

  { path: 'timeline', component: TimelineComponent },
  { path: 'editor', component: EditorComponent, canActivate: [LoggedAdminGuard] },
  { path: 'login', component: LoginComponent, canActivate: [AnonymousGuard] },
  { path: 'posts/:slug', component: SinglepostComponent },
  { path: '', redirectTo: '/timeline', pathMatch: 'full' },
  { path: '**', component: TimelineComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
