import React, { useState, useContext } from 'react'

const usernameContext = React.createContext(null) as React.Context<null | [string, React.Dispatch<React.SetStateAction<string>>]>;


export const UsernameContextProvider = ({children}: {children: React.ReactNode}) =>
{
	const usernameState = useState('');
	return(
		<usernameContext.Provider value={usernameState}>{children}</usernameContext.Provider>
	)
}

export function useUserNameContext() {
    const userNameContext = useContext(usernameContext)
    if (userNameContext == null)
      throw new Error("make sure you have the context provider as an ancestor");
	return userNameContext;
}

export function useUserName() {
	const userNameContext = useContext(usernameContext)
    if (userNameContext == null)
      throw new Error("make sure you have the context provider as an ancestor");
	return userNameContext[0];
}