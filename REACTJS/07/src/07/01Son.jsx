
import {useState,useEffect,useContext} from "react"
import CustomContext from "./Context"

const Son_01 = ({user,onChangeName})=>{
    const [name,setName] = useState(user) 

    const {globalState,setGlobalState} = useContext(CustomContext)

    const handleChange = (e)=>{
        setName(e.target.value)
    }
    const handleClick = ()=>{
        onChangeName(name)
    }
    return (
        <>
            <h3>SON_01 COMPONENT</h3>
            전역 변수 : {globalState} <br/>
            자식 상태값 name : {name} <br/>
            변경하기 : <input  onChange={handleChange}  className="input" type="text"   value={name} /> 
            <button onClick={handleClick}>부모상태값 변경하기</button>
        </>
    )
}

export default Son_01