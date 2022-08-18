
import React from 'react'
import Header from './Header'
import { Input } from './Input'
import Button from '../components/Button';
import '../App.css'

interface ModalProps {
    setOpenModal:React.Dispatch<React.SetStateAction<boolean>>
}

function Modal({setOpenModal}:ModalProps) {
  return (
    <div className='modal-background'>
        <div className='modal-container'>
            <Header/>
            <Input
                width='300px'
                height='50px'
                placeholder='What is happening?'
            />
            <Button
            onClick={()=>setOpenModal(false)}
            border={"none"}
            background={"blue"}
            height={"45px"}
            radius={"0.313rem"}
            width={"100px"}
            children={"Add Post"}
            color={"#fff"}
          />
        </div>
    </div>
  )
}

export default Modal