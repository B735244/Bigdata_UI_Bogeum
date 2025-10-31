import logo from './logo.svg';
import './App.css';

import Component_01 from "./05조건부랜더링/01Component"
import Component_02 from "./05조건부랜더링/02Component"
import Component_03 from "./05조건부랜더링/03Component"

function App() {

  return (
    <div className="App">
      <h1>조건부 랜더링</h1>
      {/* if */}
      <Component_01 isAuth={false} />
      <hr/>
      {/* 삼항연산자 */}
      <Component_02 isAuth={true} />
      <hr/>
      {/* && */}
      <Component_03 items={['aaa','bbb','ccc','ddd']} />
    </div>
  );
}

export default App;
