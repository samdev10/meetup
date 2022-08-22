import React, { useState } from 'react';
import {postData} from '../../FetchApi.js'
import { useSelector, useDispatch } from 'react-redux'
import { authenticateUser, addEmail } from '../../redux/authSlice.js'

export function AuthComponent () {
  const dispatch = useDispatch();
  const email = useSelector((state) => state.auth.email);

  const handleClick = function onHandleChange(e) {
    dispatch(addEmail({email: event.target.value}))
  }

  const handleSubmit = function onSubmit(e) {
    identifyUser(email);
    e.preventDefault();
  }

  const identifyUser = async function identifyUser(email) {
      const data = await postData('/api/auth/user', email);
      dispatch(authenticateUser({user: data.user}))
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Email:
        <input type="text" value={email} onChange={handleClick} />
      </label>
      <br></br>
      <input type="submit" value="Submit" />
    </form>
  );
}

export default AuthComponent;
