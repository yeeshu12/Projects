
import React,{useEffect,useState} from 'react';
import axios from 'axios';

function App(){
  const [profile,setProfile]=useState(null);

  useEffect(()=>{
    axios.get("http://localhost:6000/profile")
    .then(res=>setProfile(res.data));
  },[]);

  if(!profile) return <p>Loading...</p>

  return(
    <div style={{fontFamily:"Arial",padding:"40px"}}>
      <h1>LeetCode Tracker</h1>
      <h2>User: {profile.username}</h2>

      <h3>Problems Solved</h3>
      <ul>
        <li>Easy: {profile.solved.easy}</li>
        <li>Medium: {profile.solved.medium}</li>
        <li>Hard: {profile.solved.hard}</li>
      </ul>

      <h3>Global Ranking</h3>
      <p>{profile.ranking}</p>
    </div>
  )
}

export default App;
