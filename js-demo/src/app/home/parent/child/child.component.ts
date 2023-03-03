import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent {
  data: string = '';

  @Output()
  sendData: EventEmitter<string> = new EventEmitter<string>();

  send() {
    this.sendData.emit(this.data);
  }

}
