import React from 'react';
import './App.css';
import { Routes, Route } from "react-router-dom";
import Post from './pages/post/Post';
import { Login } from './pages/login/Login';
import { PostDetail } from './pages/post-detail/PostDetail';


const Error = ()=>{
  return(
    <div>
      <h2>Page Not Found</h2>
    </div>
  )
}

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={ <Login/>}></Route>
        <Route path='/post' element={<Post/>}></Route>
        <Route path='/post/:id' element={<PostDetail/>}></Route>
        <Route path='*' element={<Error/>} ></Route>
      </Routes> 
     
    </div>
  );
}

export default App;
