import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  returnUrl: string;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.createForm();
  }

  private createForm() {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  public login() {
    this.authService.login(
      this.loginForm.controls['username'].value,
      this.loginForm.controls['password'].value)
      .subscribe(
        principal => {
          // this.alertService.success("Login for " + principal.userName).timeout(5).show();
          this.router.navigate([this.returnUrl]);
        },
        error => {
          // this.alertService.handleError(error.error);
        });
  }

}
