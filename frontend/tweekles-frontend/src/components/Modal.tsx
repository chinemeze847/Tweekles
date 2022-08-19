import React from "react";
import Header from "./Header";
import { Input } from "./Input";
import Button from "../components/Button";
import "../App.css";

interface ModalProps {
  setOpenModal: React.Dispatch<React.SetStateAction<boolean>>;
}

function Modal({ setOpenModal }: ModalProps) {
  return (
    <div className="modal-background">
      
      <div className="modal-container">
        <div>
          <Header />
        </div>
        <div className="modal-input">
          <Input width="275px" height="40px" placeholder="What is happening?" />
        </div>
        <div className="modal-button">
          <Button
          onClick={() => setOpenModal(false)}
          border={"none"}
          background={"blue"}
          height={"35px"}
          radius={"0.313rem"}
          width={"75px"}
          children={"Add Post"}
          color={"#fff"}
          />
        </div>
      </div>
    </div>
  );
}

export default Modal;
