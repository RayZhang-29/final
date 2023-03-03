import {Component} from "@angular/core";
import {NgForm} from "@angular/forms";
import {AuthService} from "../shared/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(
    private auth: AuthService,
    private router: Router
    ) {
  }

  // Improve performance: pure pipes; lazy loading; caching

  submit(loginForm: NgForm): void {
    // console.log(loginForm);
    const user = loginForm.value;
    this.auth.login(user)
      .subscribe(res => {
        console.log(res);
        if (res.success) {
          this.auth.user = res.user;
          // navigate to home
          this.router.navigate(['/home']).catch();
          // update login to logout
        }
      });

  }
}
