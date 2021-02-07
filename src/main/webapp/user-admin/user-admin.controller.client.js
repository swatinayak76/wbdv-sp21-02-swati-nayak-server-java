(function() {
	var $usernameFld, $passwordFld;
	var $firstNameFld, $lastNameFld, $roleFld;
	var $removeBtn, $editBtn, $createBtn;
	var $userRowTemplate, $tbody;
	var userService = new AdminUserServiceClient();
	$(main);
	
	function addUser() {
		  createUser({
			  username : $usernameFld.val(),
		        password : $passwordFld.val(),
		        firstName : $firstNameFld.val(),
		        lastName : $lastNameFld.val(),
		        role : $roleFld.val()
		  })
		}
		var users = [];

	function createUser(user) {
		if(!validateUser()){
			  return false;
		  }
	  userService.createUser(user)
	    .then(function (actualUser) {
	      users.push(actualUser)
	      renderUsers(users)
	    })
	}

	var selectedUser = null
	function selectUser(event) {
	  var selectBtn = jQuery(event.target)
	  var theId = selectBtn.attr("id")
	  selectedUser = users.find(user => user._id === theId)
	  $usernameFld.val(selectedUser.username);
	  $passwordFld.val(selectedUser.password);
	  $firstNameFld.val(selectedUser.firstName);
	  $lastNameFld.val(selectedUser.lastName);
	  $roleFld.val(selectedUser.role);
	  $("#btnUserAdd").hide();
	}

	function deleteUser(event) {
	    console.log(event.target)
	    if(confirm('Are you sure you want to delete user?')){
	    	var deleteBtn = jQuery(event.target)
		    var theClass = deleteBtn.attr("class")
		    var theIndex = deleteBtn.attr("id")
		    var theId = users[theIndex]._id
		    console.log(theClass)
		    console.log(theIndex)

		    userService.deleteUser(theId)
		      .then(function (status) {
		    	  users.splice(theIndex, 1)
		        renderUsers(users)
		      })
	    }
	}

	function updateUser() {
		  console.log(selectedUser)
		  if(!validateUser()){
			  return false;
		  }
		  selectedUser.username = $usernameFld.val()
		  selectedUser.password = $passwordFld.val()
		  selectedUser.firstName = $firstNameFld.val()
		  selectedUser.lastName = $lastNameFld.val()
		  selectedUser.role = $roleFld.val()
		  userService.updateUser(selectedUser._id, selectedUser)
		    .then(function (status) {
		      var index = users.findIndex(user => user._id === selectedUser._id)
		      users[index] = selectedUser
		      renderUsers(users)
		    })
		  $usernameFld.val("");
	      $passwordFld.val("");
	      $firstNameFld.val("");
	      $lastNameFld.val("");
	      $roleFld.val("");
	      $("#btnUserAdd").show();
		}
	
	function validateUser() {
		var msg = "";
		
		if(($usernameFld.val() == null || $usernameFld.val() == "") ){
			msg += "User Name, "
		}
		
		if(($passwordFld.val() == null || $passwordFld.val() == "") ){
			msg += "Password, "
		}
		
		if(($firstNameFld.val() == null || $firstNameFld.val() == "") ){
			msg += "Fisrt Name, "
		}
		
		console.log(msg);
		if(msg != ""){
			msg = msg.replace(/,\s*$/, "");
			alert(msg+" is required.");
			return false;
		}
		return true;
	}
	
	function renderUsers(users) {
		  theTableBody.empty()
		  for (var i = 0; i < users.length; i++) {
		    var user = users[i]
		    theTableBody
		      .prepend(`
		    <tr>
		        <td>${user.username}</td>
		        <td></td>
		        <td>${user.firstName}</td>
		        <td>${user.lastName}</td>
		        <td>${user.role}</td>
		        <td align="right">
		        <i class="fa fa-times wbdv-delete" id="${i}"></i>
		        <i class="far fa-marker wbdv-select" id="${user._id}"></i>
		        </td>
		    </tr>
		  `)
		  }
		  jQuery(".wbdv-delete")
		    .click(deleteUser)
		  jQuery(".wbdv-select")
		    .click(selectUser)
		}

	function main() {
		  $usernameFld = $("#usernameFld")
		  $passwordFld = $("#passwordFld")
		  $firstNameFld = $("#firstNameFld")
		  $lastNameFld = $("#lastNameFld")
		  $roleFld = $("#roleFld")
		  $createBtn = $(".wbdv-create-btn")
		  addUserBtn = jQuery("#wbdv-create-user")
		  addUserBtn.click(addUser)
		  $updateBtn = $(".wbdv-update-btn")
		  theTableBody = jQuery("tbody")
		  $updateBtn.click(updateUser)
		  $createBtn.click(() => {
		      createUser({
		        username : $usernameFld.val(),
		        password : $passwordFld.val(),
		        firstName : $firstNameFld.val(),
		        lastName : $lastNameFld.val(),
		        role : $roleFld.val()
		        
		      })
		    }
		  )

		  userService.findAllUsers()
		    .then(function (actualUsersFromServer) {
		      users = actualUsersFromServer
		      renderUsers(users);
		      $(document).ready(function(){
			        $('#adminTable').dataTable({
			            "bSort": false
			        } );
			    });
		    })
		    
		   
		}
})();
