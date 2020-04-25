import { combineReducers } from 'redux';
import {SET_LIBRARIES} from '../actions';

function libraries(state = [], action){
    switch(action.type){
        case SET_LIBRARIES:
            return action.libs;
        default: 
            return state;
    }
}

const rootReducer = combineReducers({ libraries });
export default rootReducer;