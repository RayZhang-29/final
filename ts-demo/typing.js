var str = 'abc';
str = 'a';
str = '';
// str = 123; // error TS2322: Type 'number' is not assignable to type 'string'.
// implicitly assign a string type
var str2 = 'abc';
// str2 = 123;
// not initialize, implicitly define any type. no type checking
var str3; // type: any
str3 = 'abc';
str3 = 123;
str3 = {};
// strict type checking (strict mode: tsconfig: strict: true), below will be forbidden
var str4;
str4 = '123';
// str4 = 123;
str4 = undefined; // yes or no
str4 = null;
// string array
var names = ['a', 'b'];
// tuple (not immutable in ts)
var person = ['bob', 5];
person[1] = 15;
// object
var person2 = {
    name: 'charlie',
    age: 22
};
// enum
var Direction;
(function (Direction) {
    Direction[Direction["left"] = 0] = "left";
    Direction["right"] = "RIGHT";
})(Direction || (Direction = {}));
var d = Direction.left;
// union type (let)
var alphaNumeric = 'abc';
alphaNumeric = 123;
var myVar = '';
myVar = function () { };
// myVar = false; // {} matches false?
// function
// ?: optional  ts feature
// default value feature is ES6 new feature (?, = 0, two steps)
var add // not necessary
 = function (a, b) {
    if (a === void 0) { a = 0; }
    return a + b;
};
var res = add(1, 2);
// add('a', 'b');
add(1);
add();
