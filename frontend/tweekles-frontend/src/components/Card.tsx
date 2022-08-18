import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import { Link } from 'react-router-dom';
import '../App.css'

interface Props {
    username: string;
    timestamp: string;
    message: string;
    border?:string;
    onClick?:()=>void;
  }
export const Card: React.FC<Props> = ({username, timestamp, message, border, onClick}) => {

    function getTimeDifference(timestamp:string){
        let interval = new Date().valueOf() - new Date(timestamp).valueOf();
        let hours = interval / (60*60*1000);
        return Math.floor(hours) + 'h';
    }
    
    return (
      // <Link to={`/post/${Id}`}>
      <div onClick={onClick} className='card-section'>
          <p className='card-username'>@{username} <span>{getTimeDifference(timestamp)}</span></p>
          <p className='card-message'>{message}</p>
          <div className='card-comment-like'>
              <div>
              <ChatBubbleIcon className='comment' style={{ color: "yellow", fontSize:"18px"}} />
              <span>4</span>
              </div>
              <div>
              <FavoriteIcon className='like' style={{ color: "red", fontSize:"18px"}} />
              <span>5</span>
              </div>
          </div>
      </div>
    // </Link>
  )
}
