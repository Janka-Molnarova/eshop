import React from 'react';
import Welcome from "./content/Welcome";

function Content() {

    const getContentWidth = () => {
        // const width = window.innerWidth;
        // const panelWidth = document.getElementById("left-panel").clientWidth;
        // return width - (panelWidth + 100);
        console.log(window.innerWidth);
        return window.innerWidth - (200 + 100 + 40); //panel + space + padding
    }

    return <>
        <div id="content" className="panel" style={{width: getContentWidth()}}>
            <Welcome/>
        </div>
    </>
}

export default Content