import logo from './logo.svg';
import './App.css';

import { Element1, Element2, Element3, Element4, Element5 } from "./02JSX/01_Basic"
import Basic_01 from "./02JSX/01_Basic"
import CustomComponent from "./02JSX/CustomComponent"
import {Component_Event_01,Component_Event_02,Component_Event_03} from "./02JSX/03_Event"
function App() {
  // State
  const footerState = "Footer State.."
  const headerState = "Header State.."

  return (
    <div className="App">
      <header className="gnb" style={{height:"100px",backgroundColor:"red"}}>
        <h1>{headerState}</h1>
      </header>
      <main>
        <section>
          <h1>01_BASIC</h1>
          <div>
            <Element1 />
            <Element2 />
            <Element3 auth={"ROLE_USER"} name={"홍길동"} />
            <Element3 auth={"ROLE_ADMIN"} name={"티모"} />
            <hr />
            <Element4 auth={"ROLE_USER"} name={"김범수"} />
            <hr />
            <Element5 list={["aaa", "bbb", "ccc", "ddd"]} />
            <hr />
            <Basic_01.DefaultComponent1 />
            <Basic_01.DefaultComponent2 />
          </div>
        </section>
        <hr />
        <section>
          <h1>02_CUSTOM_COMPONENT</h1>
          <div>
            <CustomComponent />
          </div>
        </section>
        <hr />
        <section>
          <h1>03_EVENT_HANDLER</h1>

          <Component_Event_01 />
          <Component_Event_02 />
          <Component_Event_03 />
        </section>

      </main>
      <footer>

      </footer>
    </div>
  );
}

export default App;
