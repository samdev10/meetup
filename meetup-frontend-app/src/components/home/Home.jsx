import React from 'react';
import { useSelector, useDispatch } from 'react-redux'
import '../../css/home/home.css';
import GroupContainer from '../group/GroupContainer';
import { Link } from "react-router-dom";

function Home() {
    const user = useSelector((state) => state.auth.user);

    return (
    <div className='container'>
        <header>Welcome {user.firstname} {user.lastname}</header>
        {/*
        Add router to navigate between different view like group, events, 
        contacts lists
        */}
        <GroupContainer></GroupContainer>
    </div>
    );
}

export default Home;
