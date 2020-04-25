export const SET_LIBRARIES = 'SET_LIBRARIES';

export function setLibraries(libs){
    return {
        type: SET_LIBRARIES,
        libs
    }
}