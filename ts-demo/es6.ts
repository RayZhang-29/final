// let  const: declare variable
const a = 1;
// a = 2; Uncaught TypeError: Assignment to constant variable.

// aa is a constant but not  immutable
const aa = {x: 1};
aa.x = 2;


// let
let b = 1;
b = 2;
// b = ''; it's ok to do in es6

// let vs var  *******
// 1. let/const creates a block-scoped{} variable, var function-scoped
// 2. let/const doesn't support hoisting
// 3. let/const variable can not redeclared

for (var i = 0; i < 2; i ++ ) {}
console.log(i);

// let creates a block-scoped{} variable
for (let j = 0; j < 2; j ++ ) {}
// console.log(j);

for (var ii = 0; ii < 2; ii ++ ) {
    // event loop
    setTimeout(function () {
        console.log(ii); // 2 2
    })
}


for (var ii = 0; ii < 2; ii ++ ) {
    // closure
    (function iife(ii) {
        setTimeout(function () {
            console.log(ii); // 0 1
        });
    })(ii);
}

for (var jj = 0; jj < 2; jj ++ ) {
    // let jj:0   let jj:1
    setTimeout(function () {
        // closure
        console.log(jj); // 0 1
    });
}


// var a = 1;
// var a; // hoisting a = 1


// let b = 1;
// let b;  // cannot redeclare error

// var c = 1;
// let c;  // error

// let d = 1;  // error
// var d;



// arrow function
// must assign to a variable
let hi = (a) => {return a++};
let hi2 = a => {return a++};
let hi3 = a => a++;

/*     arrow fn vs regular fn
    1. There is no this binding in arrow fn ***
    2. Arrow function cannot be used as a constructor (no new)
    3. There is no arguments in arrow fn
 */

// this => {} nodejs
// this = globalThis = Window  browser

// order calculate getTotal
const order = {
    price: 100,
    calculate: function calculate() {
        return {
            // ***** there is no 'this' binding in arrow function
            // this means the enclosing scope's this
            getTotal: qty => qty * this.price
        };
    }
};

// find a way to invoke getTotal(5) and output 500
console.log(order.calculate().getTotal(5)); // NaN

// ... : spread operator  {} []
const obj = {
    name: 'alice',
    age: 12,
    hi: function() {},
    address: {
        city: ''
    }
};
const obj2 = {...obj, age:30}; // deep copy and update

// ...  :  rest operator (rest of arguments)  must be the last one in the params
const checkConditions = (arr, ...conditions) => {
    // implement it
    console.log(conditions);
};
const arr = [{name: 'jack', age: 1}, {name: 'bob', age: 2}];
checkConditions(arr);
checkConditions(arr, {name: 'a'});
checkConditions(arr, {name: 'a'}, {age: 1});

// destructuring
const games = ['Mario K', 'dota2'];
// const MK = games[0];
// const dota2 = hames[1];
const [MK, dota2] = games;

const games2 = {
  0: 'Gold Miner',
  1: 'Elden Ring',
  length: 2
};
// destructuring, rename key
const {0: GM, 1: ER} = games2;
console.log(games2);


// '<tr>' +
//     '<td></td>' +
// '</tr>'

// template string / literal
const tr =
    // backtick
    `<tr>
        <td>${MK.toLowerCase()}</td>
        <td>${() => dota2}</td>
    </tr>
    `;

/*  new primitive types: symbol, bigInt
*   Map, Set
*   Promise, async, await
*   xhr: es5;  fetch api: es6 return promise
*   ES6 modules
*   ..
* */




















