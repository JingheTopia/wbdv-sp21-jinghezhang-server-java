function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;

  this.url = 'https://wbdv-generic-server.herokuapp.com/api/001051630/users';
  let self = this;
  function createUser(user) {
    return fetch(self.url, {
      method: 'POST',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(user)
    }).then(function (response) {
      return response.json()
    })
  }


  function findAllUsers() {
    return fetch(self.url)
      .then(function (response) {
        return response.json()
    })
  }

  function findUserById(userId) {
    return fetch(`${self.url}/${userId}`)
        .then(response => response.json())
  }

  function updateUser(courseId, course) {
    return fetch(`${self.url}/${courseId}`, {
      method: 'PUT',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(course)
    }).then(response => response.json())
  }


  function deleteUser(userId) {
    return fetch(`${self.url}/${userId}`,
      {method: 'DELETE'})
  }
}
