import './App.css';
import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom';
import TopPanel from "./components/TopPanel";
import Content from "./components/Content";
import LeftPanel from "./components/LeftPanel";

function App() {

    const screenWidth = 1920;

    return (
        <Router>
            <div className="app">
                <TopPanel/>
                <LeftPanel/>
                <Content {...screenWidth}/>
            </div>
        </Router>
    );
}

export default App;
