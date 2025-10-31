import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router ,Routes,Route} from "react-router-dom"

import About from "./06ROUTE/About"
import Home from "./06ROUTE/Home"
import Contact from './06ROUTE/Contact';

function App() {

  return (
    <div className="App">
      {/* <h1>REACT ROUTE</h1> */}

      <Router>
        <Routes >
          <Route path="/" element={<Home />} />
          <Route path="/About" element={<About />}/>
          <Route path="/Contact/:name?/:age?" element={<Contact />} />
        </Routes>
      </Router> 
      
    </div>
  );
}

export default App;
