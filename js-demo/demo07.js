/* Promise (ES6 Promise APT FOR this demo)
	promise is an object that wraps an async operation 
			that may succeed or fail.
	promise has 3 states:
		pending: when promise is created, it's in a pending state
		resolved: when async operation successfully finished...
		rejected: when async operation failed, ...

	Made a promise 	- created a promise
	                   Pending state
	
	success			- Resolved / Fullfilled
	
	failed  		- Rejected
	
	how to handle promise?
	.then() to handle resolved (&rejected) promise
	.catch() to handle rejected promise
*/

var thuPromise = new Promise(function(resolve, reject) {
	setTimeout(function studying() {
		if (Math.random() > 0.1) {
			resolve('He studied hard enough');
		} else {
			reject('He didn\'t studied hard enough');
		}

	}, 2000);
});

/*  
	1. there is no way to jump out of promise chain
	2. if there is an error, js will create a rejected promise wrapping 
	   the error object
	3. we can return a resolved / rejected promise that will be handled 
	   in the following chain
	4. returned data will be wrapped into a resolved / rejected promise
*/

thuPromise
	.then(function resolvedHandler(data) {
		console.log(data);
		console.log('He joined THU');
		// System.exit(0);
		// return 123;
		// return Promise.reject('custom promise');
	})
	.then(function resolvedHandler(data) {
		console.log('sec then: ' + data);
	})
	.catch(function rejectedHandler(err) {
		console.log(err);
		console.log('He failed to join THU');
	});











(function(a) {
    /* iife scope:
       fn: Midterm
       var m, y
    */
    function Midterm() {
        /* Midterm scope:
           var z
        */
        // this => {x: 'hi', y: 'hello', z: 'bye'}
        this.x = 'you'; // {x: 'you', y: 'hello', z: 'bye'}
        y = 'know'; // iife scope y = know
        var z = function(a) {
            /* fn z scope:
                var a;
                var y;
            */
            // this => {} 
            this.x = 'we'; // {x: we}
            var y = 'no'; // fn z scope y = no
            console.log(a); // undefined
            setTimeout(function() {
                // will be called last
                console.log(this.x); // undefined
                console.log(this.y); // undefined
                console.log(y); // 
            });
            y = 'dunno'; // fn z scope y = dunno
        };
        z.prototype.z = 'yes'; // z.prototype: {z: yes}
        return z;
    }
    try {
        var m = Midterm.call({x: 'hi', y: 'hello', z: 'bye'}); // m => fn z
        console.log(new m()); // {x: we}
        console.log(x); // ref error
        var y = 'I';
    } catch {
        console.log(window.x); // undefined
        console.log(y); // know
    }
})('js');

// output:  undefined {x: we} undefined know undefined undefined dunno


//  q3:

function Person(name) {
    typeof name === 'string' && (this.name = name);
}

function Student(name, score) {

}
Student.prototype.sayHello = function() {};