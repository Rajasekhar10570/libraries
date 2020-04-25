import React, {Component} from 'react';
import './styles/index.css';

import LibrariesList from './components/librariesList.js';

class App extends Component{
    render(){
        return(
        	<div className="App">
        	<h3>
            	Libraries Demo
            </h3>
                <LibrariesList />
            </div>
        )
    }
}
export default App;