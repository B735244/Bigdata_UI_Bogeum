import logo from './logo.svg';
import './App.css';

import EventComponent_01 from "./04EVENT/01OnClick"
import EventComponent_02 from "./04EVENT/02OnMouse"
import EventComponent_03 from "./04EVENT/03OnKey"
import EventComponent_04 from "./04EVENT/04OnChange"
import EventComponent_05 from "./04EVENT/05OnSubmit"
import EventComponent_06 from "./04EVENT/06OnScroll"

function App() {

  return (
    <div className="App">
      <h1>EVENT HANDLING</h1>
      {/* 01 onClick */}
      <EventComponent_01 />
      <hr/>
      {/* 02 onMouse */}
      <EventComponent_02 />
      <hr/>
      {/* 03 onKey */}
      <EventComponent_03 />
      <hr/>
      {/* 04 onChange */}
      <EventComponent_04 />
      <hr/>
      {/* 05 onForm */}
      <EventComponent_05 />
      <hr/>
      {/* 06 onScroll */}
      <EventComponent_06 />
      
    </div>
  );
}

export default App;
