import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from 'src/app/models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly _userstate = new BehaviorSubject<User>(new User());

  isLoggedIn = false;
  readonly userstate$ = this._userstate.asObservable();
  constructor() { }

  get state(): User {
    return this._userstate.getValue();
  }

  set state(newState: User) {
    this.isLoggedIn = true;
    this._userstate.next(newState);
  }

  removeState() {
    this.isLoggedIn = false;
    this.state = new User();
  }
}
