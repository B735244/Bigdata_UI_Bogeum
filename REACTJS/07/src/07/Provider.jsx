import {useState} from 'react'
import CustomContext from "./Context"

const CustomProvider = ({children})=>{

    const [globalState,setGlobalState] = useState("KOREA_GLOBAL")

    return (
        <CustomContext.Provider value={{globalState,setGlobalState}}>
           {children}     
        </CustomContext.Provider>
    )

}


export default CustomProvider