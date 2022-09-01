import React, { useState } from 'react';
import { useSelector } from 'react-redux'
import AuthComponent from './components/auth/AuthComponent.jsx'
import AppContainer from './components/AppContainer.jsx'
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import { BrowserRouter } from "react-router-dom";

function App() {
  const user = useSelector((state) => state.auth.user);

  const renderApp = (user) => {
    if(user === undefined) {
      return (<AuthComponent></AuthComponent>);
    } else {
      return (<AppContainer></AppContainer>);
    }
  }

  return (
    <BrowserRouter>
      <div className="App">
        <div id="container">
          {renderApp(user)}
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
