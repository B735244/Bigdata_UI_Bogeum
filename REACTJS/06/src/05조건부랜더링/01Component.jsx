

const Component_01 = ({isAuth})=>{

    if(isAuth)
    {
        return (
            <div>
                <h2>현재 로그인된 상태입니다</h2>
            </div>
        )
    }
    else
    {
        return (
            <div>
                <h2>로그인 인증이 필요합니다</h2>
            </div>
        )
    }

}


export default Component_01