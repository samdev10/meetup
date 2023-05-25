import React from 'react';
import Home from './home/Home.jsx';
import About from './about/About.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import EventsContainer from './events/EventsContainer.jsx';
import GroupContainer from './group/GroupContainer.jsx';
import AuthComponent from './auth/AuthComponent.jsx';

function AppContainer() {

  return (
    <Routes>
      <Route path='/login' element={AuthComponent} />
      <Route path='/' element={<Home/>}>
        <Route index element={<GroupContainer />} />
        <Route path='about' element={<About/>}/>
      {/*
      Use it as :
      Render current router url
      <outlet>
      Add link:
      <Link className='btn btn-primary' to="/about">About</Link>
    */}
      <Route
      path="*"
      element={
        <main style={{ padding: "1rem" }}>
          <p>There's nothing here!</p>
        </main>
      }
      />
      </Route>
      <Route path='/events/:groupId' element={<EventsContainer/>}></Route>
    </Routes>
    )
}

export default AppContainer;
