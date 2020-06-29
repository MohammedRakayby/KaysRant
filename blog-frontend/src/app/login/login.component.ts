import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ResponseModel } from '../models/response.model';
import { UserService } from '../services/userservice/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  constructor(private httpClient: HttpClient,
    private fb: FormBuilder,
    private router: Router,
    private userService: UserService) {
    this.form = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  login() {
    const val = this.form.value;
    const url = "http://localhost:8080/auth/login";
    if (val.email && val.password) {
      this.httpClient.post<ResponseModel>(url, { "username": val.email, "password": val.password }).subscribe((res) => {
        debugger;
        if (res.status) {
          console.log("User is logged in");
          this.userService.state=res.data;
          this.router.navigateByUrl('/');
        } else {
          console.log("login failed " + res.message);
        }
      });;
    }
  }
}
