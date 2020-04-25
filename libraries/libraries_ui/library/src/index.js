import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import { createStore } from 'redux';
import { Provider } from 'react-redux';
import rootReducer from './reducers';

const store = createStore(rootReducer);
store.subscribe(() => console.log('store', store.getState()));

ReactDOM.render(
	    <Provider store={store}>
	       <Router>
	           <Switch>
	               <Route exact path="/">
	                    <App />
	               </Route>
	           </Switch>
	       </Router>
	    </Provider>
	, document.getElementById('root'));