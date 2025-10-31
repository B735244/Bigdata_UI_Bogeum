

const Component_02 = ({ isAuth }) => {

    // return (
    //     <>
    //         {isAuth ? (
    //             <>
    //                 <p>로그인완료</p>
    //                 <p>환영합니다</p>
    //             </>
    //         ) : (
    //             <>
    //                 <p>로그인실패</p>
    //                 <p>로그인을 하세요 - !</p>
    //             </>
    //         )}
    //     </>
    // )
    return isAuth ? <p>로그인확인</p> : <p>로그인실패</p>
}


export default Component_02