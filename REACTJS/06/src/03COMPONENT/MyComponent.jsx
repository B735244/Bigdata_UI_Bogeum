import {useState,useEffect} from "react"

const MyComponent = ()=>{
    //state
    // let count = 0
    const [count,setCount] = useState(1)
    //handler
    const handleClick=()=>{
        // count++;
        setCount(count+1)     //비동기 함수
        // console.log(count);
    }
    //최초 1회 실행(1회만 랜더링 이후 처리 Hook)
    useEffect(()=>{
        console.log("init setting");
    },[])
    //count state 가 변경될때마다 실행((변경될때마다 랜더링 이후 처리 Hook))
    useEffect(()=>{
        console.log("count state changed..",count);
    },[count])
    
    return (
        <>
            <h2>MyComponent...</h2>
            <button onClick={handleClick}>Btn Count : {count}</button>
        </>
    )
}


export default MyComponent