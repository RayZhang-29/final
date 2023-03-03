var express = require('express'),
	bodyParser = require('body-parser'),
	mongoose = require('mongoose'),
	cors = require('cors'),
	Schema = mongoose.Schema,
	studentSchema,
	Student,
	app = express(),
	users = [
		{name: 'alice', age: 12},
		{name: 'bob', age: 20}
	]

;

// open a port to allow connection
app.listen(3000);

// path: '/' will match any request, use a middleware
app.use(bodyParser.json());
// Access-Control-Allow-Origin
app.use(cors());

// fake login middleware
function randomSignIn(req, res, next) {
	if (Math.random() > 0.5) {
		next();
	} else {
		res.send('<h1 style="color: blue">Access Denied!</h1>');
	}
}

// GET /hello to localhost:3000      middleware: a function that has access to req, res, next
app.get('/hello', randomSignIn, function(req, res, next) {
	// if no res sent, req will be hanging
	// res.send('Hello from NodeJS');
});

app.get('/users', function getUsers(req, res) {
	res.send(users);
});


// CRUD  POST  /users {} => [{}, {}, {}]
//       PUT   /users {} => [{}]
// GET : produce the same result (idempotent)
// Delete => []  (idempotent)

// GET is used to request data from a specified resource.  (idempotent)

// POST is used to send data to a server to create/update a resource.
// PUT is used to send data to a server to create/update a resource.
// The difference between POST and PUT?  PUT requests are idempotent. 
// That is, calling the same PUT request multiple times will always produce the same result. 
// In contrast, calling a POST request repeatedly have side effects of creating the same resource multiple times.

// The DELETE method deletes the specified resource.


// POST /users
app.post('/users', function postUsers(req, res, next) {
	var user = req.body;
	users.push(user);
	res.send(users);
});

// GET /users/alice
app.get('/users/:name', function getUserByName(req, res, next) {
	var name = req.params.name,
		user = users.find(function(u) {
			return u.name.toLowerCase() === name.toLowerCase();
		});
	res.send(user);
});

// PUT /users/alice
app.put('/users/:name', function putUsers(req, res, next) {
	var user = req.body,
		name = req.params.name,
		idx = users.findIndex(function(u) {
			return u.name.toLowerCase() === name.toLowerCase();
		});
	
	idx === -1 ? users.push(user) : users.splice(idx, 1, user);  // users[idx] = user;
	// splice(): replace (remove, add)
	res.send(users);
});

// DELETE  /users/alice
app.delete('/users/:name', function deleteUsers(req, res, next) {
	var name = req.params.name,
		idx = users.findIndex(function(u) {
			return u.name.toLowerCase() === name.toLowerCase();
		});
	idx === -1 ? res.send(users) : users.splice(idx, 1);
	res.send(users);
});


// ES6
mongoose.Promise = Promise;
mongoose.connect('mongodb://127.0.0.1:27017/mercury')
		.then(function() {
			console.log('mongodb connected!')
		})
		.catch(function(e) {
			console.log(e.message);
		});

studentSchema = new Schema({
	name: {required: true, unique: true, type: String},
	score: {type: Number, min: 0, max: 100},
	address: {
		city: String,
		state: String
	}
}, {collection: 'students'});

Student = mongoose.model('Student', studentSchema);

// GET  /students
app.get('/students', function getStudents(req, res, next) {
	Student.find({})
		.then(function(docs) {
			res.send(docs);
		}) 
		.catch(function(e) {
			res.send(e.message);
		});
});

// POST /students
app.post('/students', function postStudents(req, res, next) {
	var student = new Student(req.body);
	student.save()
		.then(function(docs) {
			res.send(docs);
		})
		.catch(function(e) {
			res.send(e.message);  // TODO: {success: boolean}
		});
});



















