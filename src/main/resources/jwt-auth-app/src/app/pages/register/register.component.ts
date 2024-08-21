import {booleanAttribute, Component} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {RegistrationRequest} from "../../services/models/registration-request";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {username: "", password: "", firstName: "", lastName: "", email: ""};
  errorMessage: Array<string> = [];

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
  ) {}

  register(){
    this.errorMessage = [];
    this.authenticationService.register({
      body: this.registerRequest
    }).subscribe({
      next: () => {
        this.router.navigate(['activate-account'])
      },
      error: (err) => {
        this.errorMessage = err.error.validationErrors;
      }
    })
  }

  login(){
    this.router.navigate(['login']);
  }
}
