import {Component, ViewEncapsulation} from "@angular/core";
import {AuthService} from "../shared/services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  // encapsulation: ViewEncapsulation.Emulated
})

export class HeaderComponent {
  title = 'MSI-Ecommerce';
  constructor(public auth: AuthService) {}

  // logout() {
  //   this.auth.logout()
  //     .subscribe( res => {
  //       res.success && (this.auth.user = null);
  //     });
  // }
}
