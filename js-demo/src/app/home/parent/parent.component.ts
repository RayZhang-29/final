import {
  AfterContentInit,
  AfterViewInit, ChangeDetectorRef,
  Component,
  ContentChild,
  DoCheck,
  ElementRef,
  OnInit,
  ViewChild
} from '@angular/core';
import {ChildComponent} from "./child/child.component";

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
// list and use and try all the lifecycle hook methods in this parent component

// monkey patch
// change detector:
// every component has a change detector

//    change detection (to synchronize model and view)
//    3 types of async operation that will trigger change detection:
//        1.timed events
//        2.browser events
//        3.ajax: promise, observable

// change detection: OnPush strategy (set OnPush on every component)
// afterviewchecked, aftercontentchecked, docheck
export class ParentComponent implements OnInit, AfterViewInit, AfterContentInit, DoCheck {
  childData: string = '';
  @ViewChild('h4')  // use marker
  h4!: ElementRef;

  @ViewChild(ChildComponent)
  child!: ChildComponent;

  @ContentChild('hi')
  hi!: ElementRef;

  // how to mannully trigger CD?
  constructor(
    // cdr: ChangeDetectorRef
  ) {
    // cdr.detectChanges();
  }

  updateChildData(event: string) {
    this.childData = event;
  }

  ngOnInit() {
    // console.log(this.h4);
    // this.h4.nativeElement.style.color = 'red';
  }

  ngAfterContentInit() {
    this.hi.nativeElement.style.fontWeight = 'bold';
  }

  ngAfterViewInit() {
    console.log(this.h4);
    console.log(this.child)
    this.h4.nativeElement.style.color = 'red';
    // viewInit is executed after contentInit
    this.hi.nativeElement.style.fontSize = '26px';
  }

  // when parent change detector finished detecting changes, child doCheck will be called.
  ngDoCheck() {
  }
}
