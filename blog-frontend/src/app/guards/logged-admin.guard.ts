import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { UserService } from '../services/userservice/user.service';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoggedAdminGuard implements CanActivate {
  constructor(private userService: UserService) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    let status: boolean = false;
    if (this.userService.isLoggedIn) {
      let user: User = this.userService.state;
      // if (user.userName.length > 0) {
        status = true;
      // }
    }
    return status;
  }
}
