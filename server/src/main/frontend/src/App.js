import React from 'react';
import './App.css';
import {Calc} from "./components/Calc";
import {BrowserRouter as Router, Route} from 'react-router-dom'

function App() {
    return (
        <Router>
            <Route path="/" exact component={Calc}/>
        </Router>
    );
}

export default App;
