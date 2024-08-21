import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationRequest} from "../../services/models/authentication-request";
import {AuthenticationService} from "../../services/services/authentication.service";
import {TokenService} from "../../services/token/token.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  authenticationRequest: AuthenticationRequest = {username: '', password: ''};
  errorMessage: Array<string> = [];

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private tokenService: TokenService
  ) {
  }

  login() {
    this.errorMessage = [];
    this.authenticationService.authenticate({
      body: this.authenticationRequest
    }).subscribe({
      next: (res) => {
        this.tokenService.token = res.token as string;
        this.router.navigate(['books']);
      },
      error: (err) => {
        console.log(err);
        if (err.error.validationErrors) {
          this.errorMessage = err.error.validationErrors;
        } else {
          this.errorMessage.push(err.error.errorMessage);
        }
      }
    });
  }

  register() {
    this.router.navigate(['register']);
  }
}
