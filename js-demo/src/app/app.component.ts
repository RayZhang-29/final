import { Component } from '@angular/core';

@Component({
  // metadata
  selector: 'app-root',  // element selector
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ng15demo';
  link: string = 'https://leetcode.com';

  constructor() {
    setTimeout( () => {
      this.title = 'abc';
    }, 2000)
  }

  changeTitle() {
    this.title = 'title changed';
  }

  updateTitle(event: Event) {
    this.title = (event.target as HTMLInputElement).value;  // copp with ts
  }
}
