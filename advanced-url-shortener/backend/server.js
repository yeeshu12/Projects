
const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();
const PORT = 5000;

app.use(cors());
app.use(bodyParser.json());

const db = new sqlite3.Database('./urls.db');

db.serialize(() => {
  db.run(`CREATE TABLE IF NOT EXISTS urls (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    original TEXT,
    short TEXT UNIQUE,
    clicks INTEGER DEFAULT 0
  )`);
});

function generateCode(length = 6){
  const chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  let code="";
  for(let i=0;i<length;i++){
    code+=chars[Math.floor(Math.random()*chars.length)];
  }
  return code;
}

app.post('/shorten',(req,res)=>{
  const {url}=req.body;
  const short=generateCode();
  db.run("INSERT INTO urls(original,short) VALUES (?,?)",[url,short],function(err){
    if(err) return res.status(500).json(err);
    res.json({short});
  });
});

app.get('/:code',(req,res)=>{
  const code=req.params.code;
  db.get("SELECT * FROM urls WHERE short=?",[code],(err,row)=>{
    if(!row) return res.status(404).send("Not found");
    db.run("UPDATE urls SET clicks=clicks+1 WHERE short=?",[code]);
    res.redirect(row.original);
  });
});

app.get('/analytics/all',(req,res)=>{
  db.all("SELECT * FROM urls",(err,rows)=>{
    res.json(rows);
  });
});

app.listen(PORT,()=>console.log("Server running on "+PORT));
