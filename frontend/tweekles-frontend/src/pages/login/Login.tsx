import React, { useState , createContext} from 'react';
import "./login.css"
import { Input } from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import Header from '../../components/Header';

export const Login = () => {

  let navigateTo = useNavigate();
  
  const [username, setUsername] = useState("");

  const saveUsername = () => 
  {
    localStorage.setItem("username",JSON.stringify(username));
    navigateTo(`/post/`);
  }


  return (
          <main className='login-container'>
                <div className= 'box'>
                  <Input width='unset' height='50px' placeholder='Username' onChange={(e)=>setUsername(e.target.value)}/>
                  <Button
                      border={"none"}
                      background={"blue"}
                      height={"45px"}
                      radius={"0.313rem"}
                      width={"100px"}
                      children={"Login"}
                      color={"#fff"}
                      onClick={()=>saveUsername()}
                      />
                </div>
          </main>
  )
}
