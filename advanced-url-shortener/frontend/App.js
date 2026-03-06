
import React, {useState,useEffect} from 'react';
import axios from 'axios';

function App(){
  const [url,setUrl]=useState("");
  const [short,setShort]=useState("");
  const [data,setData]=useState([]);

  const shorten=async()=>{
    const res=await axios.post("http://localhost:5000/shorten",{url});
    setShort(res.data.short);
  }

  const load=async()=>{
    const res=await axios.get("http://localhost:5000/analytics/all");
    setData(res.data);
  }

  useEffect(()=>{load()},[]);

  return(
    <div style={{padding:"40px",fontFamily:"Arial"}}>
      <h1>URL Shortener</h1>
      <input value={url} onChange={e=>setUrl(e.target.value)} placeholder="Enter URL"/>
      <button onClick={shorten}>Shorten</button>
      {short && <p>Short link: http://localhost:5000/{short}</p>}

      <h2>Analytics</h2>
      <ul>
        {data.map(d=>(
          <li key={d.id}>{d.short} - clicks: {d.clicks}</li>
        ))}
      </ul>
    </div>
  )
}

export default App;
