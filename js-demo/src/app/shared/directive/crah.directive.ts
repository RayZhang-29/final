import {Directive, HostBinding, HostListener} from "@angular/core";

@Directive({
  selector: '[appCrah]'
})
export class CrahDirective {
  // Decorator: bind to the host element property
  @HostBinding('style.color')
  color = 'red';

  @HostListener('click', ['$event'])
  alertHello(event: Event) {
    alert('hello' + (event.target as HTMLElement).textContent);
  }

}
