import React from 'react'
import '../App.css'

interface inputProps {
  width:string,
  height:string,
  placeholder:string,
  value?:string,
  onChange?: (e:React.ChangeEvent<HTMLInputElement>)=> void,
}

export const Input = ({width, height, placeholder, value, onChange}:inputProps) => {
  return (
      <form className='form-input' action='' encType='' method='post'>
        <input className = "input-style"style={{width, height}} placeholder={placeholder} type="text" value={value} onChange={onChange}/>
      </form>
  )
}
