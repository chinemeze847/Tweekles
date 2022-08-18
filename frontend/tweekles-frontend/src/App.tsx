import React from 'react';
import './App.css';
import { Card } from './components/Card';
import Post from './pages/post/Post';
import { Login } from './pages/login/Login';

function App() {
  return (
    <div className="App">
      <Post/>
      <Login/>
    </div>
  );
}

export default App;
