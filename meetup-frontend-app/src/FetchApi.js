// Example POST method implementation:
export function getAuthToken() {
  const token = localStorage.getItem('token');
  const jwtToken = token ? token : '';
  return jwtToken
}

export async function postData(url = "", data = {}, params = undefined) {
  const token = getAuthToken();
  // Default options are marked with *
  if (params) {
    url += "?" + new URLSearchParams(params).toString();
  }
  const response = await fetch(url, {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Authorization": `Bearer ${token}`,
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data), // body data type must match "Content-Type" header,
  });
  return response.json(); // parses JSON response into native JavaScript objects
}

export function postDataWithFetch(url = "", data = {}, params = {}) {
  const token = getAuthToken();
  // Default options are marked with *
  if (params) {
    url += "?" + new URLSearchParams(params).toString();
  }
  return fetch(url, {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Authorization": `Bearer ${token}`,
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data), // body data type must match "Content-Type" header,
  }); // parses JSON response into native JavaScript objects
}

export async function getData(url = "", data = {}, params = {}) {
  const token = getAuthToken();
  // Default options are marked with *
  if (params) {
    url += "?" + new URLSearchParams(params).toString();
  }
  const response = await fetch(url, {
    method: "GET", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Authorization": `Bearer ${token}`,
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
  });
  return response.json(); // parses JSON response into native JavaScript objects
}
