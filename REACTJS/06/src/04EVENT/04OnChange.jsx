


const EventComponent_04 = ()=>{

    const handleChange = (e)=>{
        console.log("onChange...",e)
        const {name, value, type, checked} = e.target;
        console.log(name,value,type,checked)
    }
    return (
        <div>
            <input type="text" onChange={handleChange} />       <br/>
            <input type="checkbox" onChange={handleChange} /> 체크박스  <br/>
            <input type="radio" name="radio" value="r1" onChange={handleChange} />  선택1   <br/>
            <input type="radio" name="radio" value="r2" onChange={handleChange} />  선택2   <br/>
        </div>
    )
}


export default EventComponent_04