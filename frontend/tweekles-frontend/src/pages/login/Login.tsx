import React from 'react';
import "./login.css"
import { Input } from '../../components/Input';
import Button from '../../components/Button';

export const Login = () => {
  return (

    <main className='login-container'>
      <div className= 'box'>
        <Input width='unset' height='50px' placeholder='Username'/>
        <Button
            border={"none"}
            background={"blue"}
            height={"45px"}
            radius={"0.313rem"}
            width={"100px"}
            children={"Login"}
            color={"#fff"}
            />
      </div>

    </main>
  )
}
