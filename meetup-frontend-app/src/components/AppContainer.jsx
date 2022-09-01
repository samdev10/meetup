import React from 'react';
import Home from './home/Home.jsx';
import About from './about/About.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";

function AppContainer() {

  return (
    <Routes>
      <Route path='/' element={<Home/>} exact>
      </Route>
      <Route path='about' element={<About/>} exact/>
      {/*
      Use it as :
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
    </Routes>
    )
}

export default AppContainer;
