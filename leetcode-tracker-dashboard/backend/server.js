
const express = require('express');
const cors = require('cors');
const app = express();
const PORT = 6000;

app.use(cors());
app.use(express.json());

// mock data (replace later with real LeetCode API scraping)
const profile = {
  username:"demo_user",
  solved:{
    easy:120,
    medium:80,
    hard:20
  },
  ranking:15000
}

app.get("/profile",(req,res)=>{
  res.json(profile);
});

app.listen(PORT,()=>console.log("Tracker running "+PORT));
