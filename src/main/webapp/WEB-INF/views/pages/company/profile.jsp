<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> Company Profile </title>
  <link rel="stylesheet" href="css/reset.css" />
  <link rel="stylesheet" href="css/profile.css" />
</head>
<body>
  <div class="card">
  <h1 class="profile-header"> Company Profile </h1>
    <ul class="list-group list-group-unbordered mb-3">
      <li class="list-group-item"><b>Name:</b> <a
        class="float-right">${userForm.username } <form:input
            path="username" type="hidden" name="username"
            value="${userForm.username }"
            class="form-control" />
      </a></li> 
      <li class="list-group-item"><b>Email:</b> <a
        class="float-right">${userForm.username } <form:input
            path="username" type="hidden" name="username"
            value="${userForm.username }"
            class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Phone Number:</b> <a
        class="float-right">${userForm.username } <form:input
            path="username" type="hidden" name="username"
            value="${userForm.username }"
            class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Address:</b> <a
        class="float-right">${userForm.username } <form:input
            path="username" type="hidden" name="username"
            value="${userForm.username }"
            class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Website:</b> <a
        class="float-right">${userForm.username } <form:input
            path="username" type="hidden" name="username"
            value="${userForm.username }"
            class="form-control" />
      </a></li>
    </ul>
    <div class="btn-div">
      <button type="submit" class="btn button1" name="addUser">Edit</button> &nbsp;
      <button type="submit" class="btn btn-secondary button2" name="cancel">Close</button>
    </div>
  </div> 

</body>
</html>