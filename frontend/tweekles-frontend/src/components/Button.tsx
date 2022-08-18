import React from 'react'

interface Props {
  border?: string;
  color?: string;
  children?: React.ReactNode;
  height?: string;
  onClick?: () => void;
  radius?: string
  width?: string;
  background:string;
}


const Button: React.FC<Props> = ({ border, color, children, height, onClick, radius, width, background}) => {
  return (
      <button
          onClick={onClick}
          style={{
            backgroundColor: background,
            border,
            borderRadius: radius,
            height,
            width, color
          }}
      >
        {children}
      </button>
  )
}

export default Button;
