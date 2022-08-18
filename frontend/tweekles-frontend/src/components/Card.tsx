import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import '../App.css'

interface Props {
    username: string;
    timestamp: string;
    message: string;
  }
export const Card: React.FC<Props> = ({username, timestamp, message}) => {

    // const hours = (timestamp)=>{
    //     const interval = Date.now() - timestamp
        
    //     return interval.ge
    // }

    
    return (
    <div className='card-section'>
        <p className='card-username'>@{username} <span>{timestamp}</span></p> 
        <p className='card-message'>{message}</p>
        <div className='card-comment-like'>
            <div>
            <ChatBubbleIcon className='comment' style={{ color: "yellow"}} />
            <span>4</span>
            </div>
            <div>
            <FavoriteIcon className='like' style={{ color: "red" }} />
            <span>5</span>
            </div>
        </div>
    </div>
  )
}
