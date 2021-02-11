let $usernameFld
let $passwordFld
let $firstNameFld
let $lastNameFld
let $roleFld
let theTableBody
let users = []
let adminUserService = new AdminUserServiceClient()

function createUser() {
  let user = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    firstName: $firstNameFld.val(),
    lastName: $lastNameFld.val(),
    role: $roleFld.val()
  }
  adminUserService.createUser(user).then(function(actualUser){
    users.push(actualUser)
    renderUsers(users)
    document.getElementById("wbdv-form-input").reset()
  })
}


function deleteUser(event) {
  let deleteIndex = $(event.target).attr("id")
  let userId = users[deleteIndex]._id
  adminUserService.deleteUser(userId).then(function(status){
    users.splice(deleteIndex, 1)
    renderUsers(users)
  })
}


let selectedUser = null
function selectUser(event) {
  let userId = jQuery(event.target).attr("id")
  selectedUser = users.find(user => user._id === userId)
  $usernameFld.val(selectedUser.username)
  $passwordFld.val(selectedUser.password)
  $firstNameFld.val(selectedUser.firstName)
  $lastNameFld.val(selectedUser.lastName)
  $roleFld.val(selectedUser.role)
}

function updateUser() {
  selectedUser.username = $usernameFld.val()
  selectedUser.password = $passwordFld.val()
  selectedUser.firstName = $firstNameFld.val()
  selectedUser.lastName = $lastNameFld.val()
  selectedUser.role = $roleFld.val()
  adminUserService.updateUser(selectedUser._id, selectedUser).then(function(status) {
    let theIdx = users.findIndex(user => user._id === selectedUser._id)
    users[theIdx] = selectedUser
    renderUsers(users)
    document.getElementById("wbdv-form-input").reset()
  })
}

let searchedUser;
function findUserById(userId) {
  adminUserService.findUserById(userId).then(function(status) {
    searchedUser = users.find(user => user._id === userId)
  })
}


function renderUsers(users) {
  theTableBody.empty()
  for (let i = 0; i < users.length; i++) {
    let user = users[i]
    theTableBody.append(`
      <tr class="wbdv-user wbdv-hidden">
        <td class="wbdv-table-content d-none d-lg-table-cell wbdv-username">${user.username}</td>
        <td>&nbsp;</td>
        <td class="wbdv-table-content d-none d-lg-table-cell wbdv-first-name">${user.firstName}</td>
        <td class="wbdv-table-content d-none d-lg-table-cell wbdv-last-name">${user.lastName}</td>
        <td class="wbdv-table-content d-none d-lg-table-cell wbdv-role">${user.role}</td>
        <td></td>
        <td class="wbdv-table-content d-none d-lg-table-cell wbdv-icons">
          <span class="pull-right">
            <i class="pull-right fa-2x fa fa-times col-md-auto wbdv-delete" id="${i}"></i>
            <i class="pull-right fa-2x fa fa-pencil col-md-auto wbdv-edit" id="${user._id}"></i>
          </span>
        </td>
      </tr>`)
  }
  jQuery(".wbdv-delete").click(deleteUser)
  jQuery(".wbdv-edit").click(selectUser)
}





function main() {
  $usernameFld = $("#usernameFld")
  $passwordFld = $("#passwordFld")
  $firstNameFld = $("#firstNameFld")
  $lastNameFld = $("#lastNameFld")
  $roleFld = $("#roleFld")
  theTableBody = jQuery(".wbdv-tbody")
  adminUserService.findAllUsers().then(function (actualUsersFromServer) {
    users = actualUsersFromServer
    renderUsers(users)
  })
}
jQuery(main)
