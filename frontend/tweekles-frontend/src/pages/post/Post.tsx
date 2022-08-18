import React from 'react'
import { Card } from '../../components/Card';
import model from '../../api/model';
import './post.css'
import Button from "../../components/Button";
import {blue} from "@mui/material/colors";
import Header from "../../components/Header";

const Post = () => {
  // @ts-ignore
    return (
    <main className="container">
        <Header/>
      <div className="wrapper">
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
      </div>
        <div className="button-add-post">
            <Button border={"none"} background={"blue"} height={"45px"}  radius={"0.313rem"} width={"100px"} children={"Add Post"} color={"#fff"}/>
        </div>
    </main>
  )
}

export default Post;
