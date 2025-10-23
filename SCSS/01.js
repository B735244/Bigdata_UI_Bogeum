import "./01.scss"

console.log("01_JS Page입니다")

const btn = document.querySelector('.container2 .btn')
let toggle=true;
btn.addEventListener('click',()=>{
    if(toggle){
        btn.classList.add('active')
    }else{
        btn.classList.remove('active')
    }
    toggle= !toggle
})