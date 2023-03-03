import {Directive, Input, TemplateRef, ViewContainerRef} from "@angular/core";

@Directive({
  selector: '[appMyIf]'
})

export class MyIfDirective {

  constructor(
    private vr: ViewContainerRef,
    private tr: TemplateRef<any>
  ) {}

  @Input()
  set appMyIf(isLoggedIn: boolean) {
    isLoggedIn ? this.vr.createEmbeddedView(this.tr) : this.vr.clear();
  }
}
