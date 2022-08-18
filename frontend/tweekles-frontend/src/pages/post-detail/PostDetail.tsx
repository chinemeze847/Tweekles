import React, { useEffect, useState } from 'react'
import './postdetail.css'
import FavoriteIcon from '@mui/icons-material/Favorite';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import Header from "../../components/Header";
import { Card } from '../../components/Card';
import { Input } from '../../components/Input';
import Button from '../../components/Button';
import axios from 'axios';
import { useParams } from 'react-router-dom';

type dummyType = { id: string, username: string, message: string, timestamp: string }
type CommentType = { id: string, username: string, comment: string, timestamp: string }
type PostType = { id: string, username: string, comment: string, timestamp: string, post: dummyType }

export const PostDetail = () => {
  const params = useParams();
  const [comments, setComments] = useState<CommentType[]>([]);
  const [commentInput, setCommentInput] = useState("")
  const [postDetailsModel, setPostDetailsModel] = useState<PostType[]>([])

  useEffect(() => {
    const getPostDetail = async () => {
      try {
        const res = await axios(`http://localhost:8080/api/v1/${params.id}/comments`)
        const comment = res.data.map((data: { id: any; username: any; comment: any; timestamp: any; }) => {
          return {
            id: data.id,
            username: data.username,
            comment: data.comment,
            timestamp: data.timestamp
          }
        })
        setPostDetailsModel(res.data)
        setComments(comment);
      } catch (error) {
        console.log(error);
      }
    }
    getPostDetail();
  }, [params.id])

  function getTimeDifference(timestamp: string) {
    let interval = new Date().valueOf() - new Date(timestamp).valueOf();
    let hours = interval / (60 * 60 * 1000);
    return Math.floor(hours) + 'h';
  }

  return (
    <main className="container">
      {
        comments.length > 0 && postDetailsModel.length > 0 &&
        <>
          <Header />
          <div style={{ border: "1px solid black" }}>
            <div className='card-section' style={{ border: "none" }}>
              <p className='card-username'>@{postDetailsModel[0].post.username} <span>{getTimeDifference(postDetailsModel[0].post.timestamp)}</span></p>
              <p className='card-message'>{postDetailsModel[0].post.message}</p>
              <div className='card-comment-like'>
                <div>
                  <ChatBubbleIcon className='comment' style={{ color: "yellow", fontSize: "18px" }} />
                  <span>4</span>
                </div>
                <div>
                  <FavoriteIcon className='like' style={{ color: "red", fontSize: "18px" }} />
                  <span>5</span>
                </div>
              </div>
            </div>

            <div style={{ marginTop: "50px" }}>
              {
                comments.map((data) => {
                  return <Card key={data.id} username={data.username} timestamp={data.timestamp} message={data.comment} hideIcon={true} />
                })
              }
            </div>
          </div>
          <div style={{
            marginTop: "50px",
            display: "flex",
            width: "100%",
            height: "50px",
            justifyContent: "space-between",
            alignItems: "flex-start",
          }}>
            <div style={{
              display: "flex",
              flexDirection: "column",
              gap: "10px",
              width: "250px"
            }}>
              <Input width={'250px'} height={'50px'} placeholder={'Add your comment'} value={commentInput} onChange={(e) => { setCommentInput(e.target.value) }} />
              <Button
                background={'orange'}
                border={"none"}
                height={"45px"}
                radius={"0.313rem"}
                width={"100px"}
                color={"#fff"}
                alignSelf={"end"}
                children="Save"
                onClick={() => setComments([...comments, { id: "1", username: "John", comment: commentInput, timestamp: (new Date()).toString() }])} />
            </div>
            <Button
              background={'red'}
              border={"none"}
              height={"45px"}
              radius={"0.313rem"}
              width={"100px"}
              color={"#fff"}
              alignSelf={"end"}
              children="Like" />
          </div>
        </>
      }
    </main>
  )
}
