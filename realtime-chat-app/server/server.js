const express=require("express");
const http=require("http");
const {Server}=require("socket.io");

const app=express();
const server=http.createServer(app);

const io=new Server(server,{
 cors:{origin:"*"}
});

io.on("connection",(socket)=>{
 console.log("user connected");

 socket.on("send_message",(data)=>{
  io.emit("receive_message",data);
 });

 socket.on("disconnect",()=>{
  console.log("user disconnected");
 });
});

server.listen(5000,()=>{
 console.log("server running");
});
