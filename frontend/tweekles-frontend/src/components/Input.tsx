import React from 'react'

interface inputProps {
  width:string,
  height:string,
  placeholder:string
}

export const Input = ({width, height, placeholder}:inputProps) => {
  return (
      <form className='form-input' action='' encType='' method='post'>
        <input style={{width, height}} placeholder={placeholder} type="text"/>
      </form>
  )
}
