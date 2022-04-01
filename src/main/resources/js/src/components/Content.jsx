import React, {Component} from 'react';
import Welcome from "./content/Welcome";

class Content extends Component {

    getContentWidth = () => {
        // const width = window.innerWidth;
        // const panelWidth = document.getElementById("left-panel").clientWidth;
        // return width - (panelWidth + 100);
        console.log(window.innerWidth);
        return window.innerWidth - (200 + 100 + 40); //panel + space + padding
    }

    render = () => {
        return <>
            <div id="content" className="panel" style={{width: this.getContentWidth()}}>
                <Welcome/>
            </div>
        </>
    }
}

export default Content