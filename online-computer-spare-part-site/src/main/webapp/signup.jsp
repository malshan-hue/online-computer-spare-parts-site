<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		
		    <style>
    
    	@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap');
    	
		body {
			background-image: url(./resources/loginBackground.jpg);
			background-repeat: no-repeat;
			background-size: cover;
			background-position: center;
			font-family: 'Montserrat', sans-serif;
		}
		
		div {
			background-color: #ffffff;
		}
		
		.container {
			width: 60%;
			padding-top: 50px;
			padding-bottom: 50px;
		}
		
		h2 {
			font-size: 3rem; 
			font-weight: 700;
			text-align: center;
		}
		
    </style>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		<title>Sign Up</title>
		
	</head>
	
	<body>
	
	<br>
	<div class="container my-3 d-flex justify-content-center align-items-center">
	    <div class="col-sm-6">
			<h2>Sign Up Now</h2><br>
			
			
			<form action="<%= request.getContextPath() %>/AddUserServlet" method="post">
			
				<div class="form-group">
					<label for="firstName">User Name</label>
					<input type="text" name="username" id="firstName" required placeholder="Your Username" required class="form-control form-control-lg">
				</div>
				
			    <div class="form-group">
					<label for="email">Email address</label>
					<input type="email" class="form-control form-control-lg" placeholder="Email" required name="email" id="email" aria-describedby="emailHelp">
			    </div>
			    
				<div class="form-group">
			        <label for="password">Password</label>
			        <input type="password" class="form-control form-control-lg" required placeholder="Password*" required name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{8,}" title="Must contain: at least one number, one uppercase letter, one lowercase letter, one special character, and 8 or more characters" required>
					<input type="checkbox" onclick="showPassword()"> Show Password
				</div> 
				
				<div class="form-group">
					<label for="Address">Mobile Number</label>
					<input type="text" name="address" required placeholder="Mobile Number" required class="form-control form-control-lg">
				</div>
				
				<div class="form-group">
					<input type="hidden" name="userRole" id="firstName" required placeholder="userRole" value="user" required class="form-control form-control-lg">
				</div>
				
				<span style="margin-top: 10px">Already have an account <a class="linkControl" href="userLogin.jsp">Login here</a></span> <br><br>
				<input type="submit" value="Register" class="btn btn-primary btn-block"><br>
			    
			</form>
	    </div>
	</div>
	
	<script>
	
		function showPassword() {
		var x = document.getElementById("password");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		
	</script>
	
	</body>
	
</html>