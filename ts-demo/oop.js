var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// class: ES6 new feature
var Shape = /** @class */ (function () {
    // public Shape() {}
    // no constructor overloading
    function Shape(type) {
        this.type = type;
    }
    Shape.prototype.printType = function () {
        console.log(this.type, Shape.x); // this.x: not possible, this depends.
    };
    Shape.printX = function () {
        console.log(Shape.x, this.x); // this: class level
    };
    return Shape;
}());
var shape = new Shape('shape');
// console.log(Shape.x); // protected cannot see from instance
Shape.printX();
var Circle = /** @class */ (function (_super) {
    __extends(Circle, _super);
    function Circle(type, radius) {
        var _this = _super.call(this, type) || this;
        _this.radius = radius;
        return _this;
    }
    return Circle;
}(Shape));
//    circle: Shape : upcasting
var circle = new Circle('circle', 10);
console.log(circle.radius); // no radius, compile error in ts, runnable in js
