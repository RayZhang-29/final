import {Drawable} from "./typing"; // .js
// import Drawable from "./typing";

// class: ES6 new feature
class Shape {
    // (ts feature) access modifiers: public, protected, private, default is public
    type: string;  // instance variable, not local
    _info: string;

    get info() {
        return this._info;
    }
    set info(info: string) {
        this._info = info;
    }

    // static is ES6 new feature
    protected static x: number;

    // public Shape() {}
    // no constructor overloading
    constructor(type: string) {
        this.type = type;
    }

    printType(): void {
        console.log(this.type, Shape.x); // this.x: not possible, this depends.
    }

    static printX() {
        console.log(Shape.x, this.x); // this: class level
    }

}

const shape: Shape = new Shape('shape');
// console.log(Shape.x); // protected cannot see from instance
Shape.printX();

class Circle<T> extends Shape implements Drawable{
    radius: T;

    constructor(type: string, radius: T) {
        super(type);  // must be first line
        this.radius = radius;
    }

    draw() {}
}

//    circle: Shape : upcasting
const circle: Shape = new Circle<number>('circle', 10);
// console.log(circle.radius); // no radius, compile error in ts, runnable in js

// // ts feature, interface is used to internal type checking
// export interface Drawable {
//     draw();
// }


// ES6 modules





















