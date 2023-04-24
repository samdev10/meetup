import React, { useState } from 'react';
import { useSelector } from 'react-redux'
import AuthComponent from './components/auth/AuthComponent.jsx'
import AppContainer from './components/AppContainer.jsx'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import './App.css';
import { BrowserRouter } from "react-router-dom";

function App() {
  const authenticated = useSelector((state) => state.auth.authenticated);
  const session = getCookie('JSESSIONID');

  function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

  const renderApp = (authenticated) => {
    if (!authenticated) {
      return (<AuthComponent></AuthComponent>);
    } else {
      return (<AppContainer></AppContainer>);
    }
  }

  return (
    <BrowserRouter>
      <div className="App">
        <div id="container">
          {renderApp(authenticated)}
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
