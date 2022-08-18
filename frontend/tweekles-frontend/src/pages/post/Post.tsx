import React from 'react'
import { Card } from '../../components/Card';
import model from '../../api/model';

const Post = () => {
  return (
    <main>
      { 
        model.map((data)=>{
          return (
            <Card 
              message={data.message}
              key = {data.id}
              username = {data.username}
              timestamp = {data.timestamp}
            />
          )
        })

      }
    </main>
  )
}

export default Post;
