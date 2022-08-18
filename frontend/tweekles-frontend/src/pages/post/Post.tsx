import React, {useState} from "react";
import { Card } from "../../components/Card";
import model from "../../api/model";
import "./post.css";
import Button from "../../components/Button";
import Header from "../../components/Header";
import { useNavigate } from "react-router-dom";
import Modal from "../../components/Modal";

const Post = () => {

  const [openModal, setOpenModal] = useState(false);

  let navigateTo = useNavigate();
  // @ts-ignore
  return (
    <main className="container">
      <Header />
      {openModal && <Modal setOpenModal={setOpenModal}/>}
      <div className="post-container">
        <div className="wrapper">
          {model.map((data) => {
            return (
              <Card
                message={data.message}
                key={data.id}
                username={data.username}
                timestamp={data.timestamp}
                onClick={()=>navigateTo(`/post/${data.id}`)}
              />
            );
          })}
        </div>
        <div className="button-add-post">
          <Button
            onClick={()=>setOpenModal(true)}
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
      
    </main>
  );
};

export default Post;
