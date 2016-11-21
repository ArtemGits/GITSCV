var express = require("express"),
	http = require("http"),
	mongoose = require("mongoose"),
	app = express(),
	services,
	mongoUrl = "mongodb://localhost/amazeriffic";

	app.use(express.static(__dirname + "/client"));
	app.use(express.bodyParser());

	if(process.env.VCAP_SERVICES) {
		services = JSON.parse(process.env.VCAP_SERVICES);
		mongoUrl = services["mongolab"][0].credentils.uri;
		console.log(process.env.VCAP_SERVICES);
	}

	console.log(mongoUrl);

	mongoose.connect(mongoUrl)

	var ToDoSchema = mongoose.Schema({
		description : String,
		tags : [ String ]
	});

	var ToDo = mongoose.model("ToDo", ToDoSchema);

	http.createServer(app).listen(process.env.PORT || 3000);

	app.get("/todos.json", function(req,res) {
		ToDo.find({},function(err, toDos) {
			res.json(toDos)
		});
	});

	app.post("/todos", function(req,res) {
		console.log(req.body);
	var newToDo = new ToDo({"description":req.body.description, "tags": req.body.tags});
	newToDo.save(function(err,result) {
		if(err !== null) {
			console.log(err);
			res.send("Error");

		} else {
			ToDo.find({},function(err, result) {
				if(err !== null) {
					console.log(err);
					res.send("Error");
				}
				res.json(result);
			});
		}
	});
	});
		
	
