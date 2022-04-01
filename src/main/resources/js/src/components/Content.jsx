import React, {useState, useEffect} from 'react';
import Welcome from "./content/Welcome";
import axios from 'axios';

function Content() {

    const [title, setTitle] = useState("");

    const getContentWidth = () => {
        // const width = window.innerWidth;
        // const panelWidth = document.getElementById("left-panel").clientWidth;
        // return width - (panelWidth + 100);
        console.log(window.innerWidth);
        return window.innerWidth - (200 + 100 + 40); //panel + space + padding
    }

    useEffect(() => {
        axios.get("https://api.chucknorris.io/jokes/random")
            .then((res) => setTitle(res.data.value))
    }, [])

    return <>
        <div id="content" className="panel" style={{width: getContentWidth()}}>
            <h1>{title}</h1>
            <Welcome/>
        </div>
    </>
}

export default Content