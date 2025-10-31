
import { useState, useEffect,useContext } from "react"
import Son_01 from "./01Son"
import CustomContext from "./Context"

const Parent_01 = () => {
    const [name, setName] = useState("홍길동")

    const {globalState,setGlobalState} = useContext(CustomContext)

    const handleChangeName = (name) => {
        setName(name)
    }
    return (
        <div>
            <h2>Parent_01 COMPONENT</h2>
            부모 상태값 name : {name} <br/>
            공유변수 : {globalState}
            <hr />

            <Son_01
                user={name}
                onChangeName={handleChangeName}
            />
        </div>
    )
}

export default Parent_01