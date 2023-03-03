import {ChangeDetectionStrategy, Component, OnDestroy} from "@angular/core";
import {interval, Subscription} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  // changeDetection: ChangeDetectionStrategy.OnPush
})


export class HomeComponent implements OnDestroy {
  p = {id: 1, name: 'iPhone', brand: 'Apple', price: 100, stock: 22, image: 'https://d2um6umu4gwssp.cloudfront.net/apple/wp-content/uploads/2016/06/iphone-1.jpg'};
  magicText = '';
  isLoggedIn = false;
  intervalSubscription: Subscription;

  constructor() {
    const intervalObs$ = interval(1000);  // add $ after name to show observable

    // memory leak
    this.intervalSubscription = intervalObs$
      .subscribe(val => console.log(val));
    this.intervalSubscription.unsubscribe();
  }

  // Angular lifecycle hook method ***** 总结

  // will be called right before component is destroyed / torn down
  // used to do clean up, cancel observable subscription(interval)
  ngOnDestroy() {
    this.intervalSubscription.unsubscribe();
  }

  // observable: create
}

