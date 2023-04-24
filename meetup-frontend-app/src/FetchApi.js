// Example POST method implementation:
export async function postData(url = '', data = {}, params= {}) {
  // Default options are marked with *
  if(params) {
    url += '?' + ( new URLSearchParams( params ) ).toString();
  }
  console.log('url', url);
  console.log('param', params);
  const response = await fetch(url, {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header,
  });
  return response.json(); // parses JSON response into native JavaScript objects
}

export function postDataWithFetch(url = '', data = {}, params= {}) {
  // Default options are marked with *
  if(params) {
    url += '?' + ( new URLSearchParams( params ) ).toString();
  }
  return fetch(url, {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header,
  }); // parses JSON response into native JavaScript objects
}

export async function getData(url = '', params = {}) {
  // Default options are marked with *
  url += '?' + ( new URLSearchParams( params ) ).toString();
  const response = await fetch(url, {
    method: 'GET', // *GET, POST, PUT, DELETE, etc.
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
  });
  return response.json(); // parses JSON response into native JavaScript objects
}
