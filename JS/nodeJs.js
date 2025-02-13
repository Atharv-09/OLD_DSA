const express = require("express");
const app = express();


app.get("/",(req,res) => {

	res.send("he");

})
	
const port = process.env.PORT;

app.listen(3000,(req,res)=>{
	console.log("server started");
})

/// would you knowo url module 

const url = require("url");

let adrs = "https://www.simplilearn.com/tutorials/nodejs-tutorial/nodejs-interview-questions";

var que = url.parse(adrs,true);
log(que.host);
		pathname
		search

// server that return hello world 

const http = require("http");

http.createServer((req,res) => {

	res.writeHead(200,{
		'content-type' : 'text/plain'
	});
	res.end("hello");

}).listen(3000,(req,res) => {
	console.log("server started");
})