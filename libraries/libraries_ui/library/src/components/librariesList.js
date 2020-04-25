import React, {Component } from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import { setLibraries } from '../actions';

class LibrariesList extends Component{
	
	constructor(){
        super();
        this.state = {
            libs: [],
            books: []
        }
    }
	
	loadData() {
        const url = `http://localhost:8080/library/all`;

        fetch(url, {method: 'GET'})
        .then(response => response.json())
        .then(response => {
        	console.log(response);
        	this.setState({libs: response});
        })
	}
	loadBookData(libId){
		const url = `http://localhost:8080/book/libbooks/${libId}`;

        fetch(url, {method: 'GET'})
        .then(response => response.json())
        .then(response => {
        	this.setState({books: response});
        })
	}
	
    render(){
        return (
        	<div className="App">
        	    <div className="load-button">
                	<button type="button" onClick={() => this.loadData()}>Load Libraries</button>
                </div>
                <div className="col-md-6">
                <h3> Libraries List</h3>
                <ul className="list-group">
                    { this.state.libs.length > 0 ?
                        this.state.libs.map(character => {
                            return (
                                <li className="list-group-item" key={character.libId}>
                                    <div className="list-item">{character.libraryName}</div>
                                    <div
                                    className="list-item right-button"
                                    onClick={() => this.loadBookData(character.libId)}
                                >
                                    +
                                </div>
                                </li>
                            )
                        }) : ""
                    }
                </ul>
                </div>
                <div className="col-md-6">
                	<h3> Books List</h3>
                	<ul className="list-group">
                    { this.state.books.length > 0 ?
                        this.state.books.map(book => {
                            return (
                                <li className="list-group-item" key={book.bookId}>
                                    <div className="list-item">{book.bookName}</div>
                                    
                                </li>
                            )
                        }) : ""
                    }
                </ul>
                </div>
            </div>
        )
    }
}


export default LibrariesList;