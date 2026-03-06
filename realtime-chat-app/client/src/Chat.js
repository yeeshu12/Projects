import React,{useState,useEffect} from "react";
import io from "socket.io-client";

const socket=io("http://localhost:5000");

function Chat(){
 const [message,setMessage]=useState("");
 const [messages,setMessages]=useState([]);

 useEffect(()=>{
  socket.on("receive_message",(data)=>{
   setMessages(list=>[...list,data]);
  });
 },[]);

 const sendMessage=()=>{
  socket.emit("send_message",message);
  setMessage("");
 };

 return(
  <div>
   <input value={message} onChange={e=>setMessage(e.target.value)} />
   <button onClick={sendMessage}>Send</button>

   {messages.map((m,i)=>(
    <p key={i}>{m}</p>
   ))}
  </div>
 );
}

export default Chat;
