import {Directive, ElementRef, Input, OnChanges, SimpleChanges} from "@angular/core";

@Directive({
  selector: '[appMyShow]',   // attribute selector

})
export class MyShowDirective implements OnChanges {
  @Input()
  appMyShow!: boolean;

  constructor(
    private er: ElementRef
  ) {}

  // will only be called whenever @Input vartiables changes
  ngOnChanges() {
    this.er.nativeElement.style.display = this.appMyShow ? '' : 'none';
  }

}
