let str: string = 'abc';
str = 'a';
str = '';
// str = 123; // error TS2322: Type 'number' is not assignable to type 'string'.

// implicitly assign a string type
let str2 = 'abc';
// str2 = 123;

// not initialize, implicitly define any type. no type checking
let str3; // type: any
str3 = 'abc';
str3 = 123;
str3 = {};

// strict type checking (strict mode: tsconfig: strict: true), below will be forbidden
let str4: string;
str4 = '123';
// str4 = 123;
str4 = undefined; // yes or no
str4 = null;


// string array
const names: string[] = ['a', 'b'];

// tuple (not immutable in ts)
const person: [string, number] = ['bob', 5];
person[1] = 15;

// object
const person2: {name: string, age: number} = {
    name: 'charlie',
    age: 22
};

// enum
enum Direction {
    left, // hint
    right = 'RIGHT'
}
const d: Direction = Direction.left;

// union type (let)
let alphaNumeric: string | number = 'abc';
alphaNumeric = 123;
//alphaNumeric = {};

// define your own type
type myType = string | number | object | [];
let myVar: myType = '';
myVar = function () {};
// myVar = false; // {} matches false?


// function
// ?: optional  ts feature
// default value feature is ES6 new feature (?, = 0, two steps)
const add: (a?:number, b?: number) => number // not necessary
    = (a: number = 0, b?: number): number => {
    return a + b;
};
const res: number = add(1, 2);
// add('a', 'b');
add(1);
add();



// ts feature, interface is used to internal type checking
// named export
export interface Drawable {
    draw();
}

// default export: only one default export per file
export default Drawable; // commong in react









