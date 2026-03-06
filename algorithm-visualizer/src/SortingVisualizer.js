import React,{useState} from "react";
import {bubbleSort} from "./algorithms/bubbleSort";

function SortingVisualizer(){
 const [array,setArray]=useState([]);

 const generateArray=()=>{
  const arr=[];
  for(let i=0;i<40;i++){
   arr.push(Math.floor(Math.random()*400));
  }
  setArray(arr);
 };

 const runBubbleSort=()=>{
  const animations=bubbleSort(array);
  console.log(animations);
 };

 return(
  <div>
   <button onClick={generateArray}>Generate Array</button>
   <button onClick={runBubbleSort}>Bubble Sort</button>

   <div style={{display:"flex",alignItems:"flex-end",height:"400px"}}>
    {array.map((value,idx)=>(
     <div key={idx} style={{height:value,width:6,margin:1,background:"blue"}}></div>
    ))}
   </div>
  </div>
 );
}
export default SortingVisualizer;
