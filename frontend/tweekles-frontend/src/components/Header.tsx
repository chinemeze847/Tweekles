import React, { useEffect, useState } from "react";
import '../App.css'
import { useUserName } from "../pages/login/loginContext";

const Header = ()=>
{
    const [user, setUser] = useState("");
    const username = useUserName();

    return(
        <header className="header">
            <p className="box-username">{username}</p>
        </header>
    )
}

export default Header;