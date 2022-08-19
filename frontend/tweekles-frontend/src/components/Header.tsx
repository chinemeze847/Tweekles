import React, { useEffect, useState } from "react";
import '../App.css'

const Header = ()=>
{
    const [user, setUser] = useState("");
    useEffect(() => 
    {
        
        const name  = JSON.parse(localStorage.getItem("username") || "");
        setUser(name);
    });

    return(
        <header className="header">
            <p className="box-username">{user}</p>
        </header>
    )
}

export default Header;