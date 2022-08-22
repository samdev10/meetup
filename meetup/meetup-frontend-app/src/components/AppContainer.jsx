import React from 'react';
import { useSelector, useDispatch } from 'react-redux'

function AppContainer() {
  const user = useSelector((state) => state.auth.user);

  return (
    <div>
    <h1>Welcome {user.firstname} {user.lastname}</h1>
    </div>
  );
}

export default AppContainer;
