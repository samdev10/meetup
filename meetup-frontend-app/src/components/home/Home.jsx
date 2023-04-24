import React from 'react';
import { useSelector, useDispatch } from 'react-redux'
import '../../css/home/home.css';
import GroupContainer from '../group/GroupContainer.jsx';
import { Outlet, Link } from "react-router-dom";

function Home() {
    const user = useSelector((state) => state.auth.user)
    console.log(user);

    return (
    <div className='container'>
        <header>Welcome {user.firstname} {user.lastname}</header>
        {/*
        Add router to navigate between different view like group, events, 
        contacts lists
        */}
        <Outlet/>
    </div>
    );
}

export default Home;
