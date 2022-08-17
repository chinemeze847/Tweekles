import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import '../App.css'

export const Card = () => {
  return (
    <div className='card-section'>
        <p className='card-username'>@TonyBologni 6h</p> 
        <p className='card-message'>I'm currently working on the "Fit for Project" initiative</p>
        <div className='card-comment-like'>
            <div>
                <FavoriteIcon/>
            </div>
            <div>
                <ChatBubbleIcon/>
            </div>
        </div>
    </div>
  )
}
