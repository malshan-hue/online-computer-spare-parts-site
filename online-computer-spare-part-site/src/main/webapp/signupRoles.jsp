<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String role = (String) session.getAttribute("role");

	if(!role.equals("admin")){
		
		String message = "Access denied. You need to be an administrator to access this page.";
        out.println("<script>alert('" + message + "'); window.location.href = 'userLogin.jsp';</script>");
        
	}
%>

<% String logoutUrl = "logout.jsp"; %>
    
<% 	
	String username = (String) session.getAttribute("user");
	
	String index = "";
	
	if(role == "admin"){
		index = "indexAdmin.jsp";
	}
	
	if (role == "inventory-Manager"){
		index = "indexInventoryManager.jsp";
	}
	
	if(role == "manager"){
		index = "indexManager.jsp";
	}
	
	if(role.equals("user")){
		index = "index.jsp";
	}
%>

<html>
	<head>
	
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		
	    <style>
    
	    	@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap');
	    	
			body {
				background-color:#f2f6fc;
				color:#69707a;
				font-family: 'Montserrat', sans-serif;
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
    
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		<title>Register Site Managers</title>
		
	</head>
	
	<body>
	
	<header>
	  <!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-white">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
				  data-mdb-target="#navbar1" aria-controls="navbarExample01" aria-expanded="false"
				  aria-label="Toggle navigation">
				  <i class="fas fa-bars"></i>
				</button>
				
				<div class="collapse navbar-collapse justify-content-between" id="navbar1">
					<ul class="navbar-nav mb-2 mb-lg-0">
					  <li class="nav-item"><span class="navbar-text">Welcome! <%= username %> <%= role %></span></li>
					</ul>
					<ul class="navbar-nav mb-2 mb-lg-0 ms-auto">
						<li class="nav-item active"><a class="nav-link" aria-current="page" href="<%=index%>">Home</a></li>
						<li class="nav-item"> <a class="nav-link" href="userProfile.jsp">Profile</a></li>
						<li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About us</a></li>
						<li class="nav-item"><a class="nav-link" href="signupRoles.jsp">Register Site Managers</a></li>
						<li class="nav-item"><a class="nav-link" href="manageUsers.jsp">Manage Users</a></li>
						<li class="nav-item"><a class="nav-link" href="addCategory.jsp">Manage Category</a></li>
						<form method="post" action="<%= logoutUrl %>" class="d-flex align-items-center">
            				<input class="btn btn-outline-primary" type="submit" value="Logout">
          				</form>
					</ul>
				</div>
			</div>
		</nav>
	<!-- Navbar -->
	
	<!-- Background image -->
		<div class="p-5 text-center bg-image" style="
			background-image: url(./resources/indexBackground.jpg);
			height: 400px;">
			<div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white">
						<br><br><br>
						<h1 class="mb-3">Register Site Managers</h1>
						<h4 class="mb-3">Spare Bytes</h4>
						<h4 class="mb-3">Computer Spare Part Sellers</h4>
						
						<br><br><br><br>
					</div>
				</div>
			</div>
		</div>
	<!-- Background image -->
	</header>
	
	<br>
	<div class="container my-3 d-flex justify-content-center align-items-center">
	    <div class="col-sm-6">
			
			<form action="<%= request.getContextPath() %>/AddUserServlet" method="post">
			
				<div class="form-group">
					<label for="firstName">User Name</label>
					<input type="text" name="username" required placeholder="Your Username" required class="form-control form-control-lg">
				</div>
				
			    <div class="form-group">
					<label for="email">Email address</label>
					<input type="email" class="form-control form-control-lg" placeholder="Email" required name="email" aria-describedby="emailHelp">
			    </div>
			    
				<div class="form-group">
			        <label for="password">Password</label>
			        <input type="password" class="form-control form-control-lg" required placeholder="Password" id="password" required name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{8,}" title="Must contain: at least one number, one uppercase letter, one lowercase letter, one special character, and 8 or more characters" required>
					<input type="checkbox" onclick="showPassword()"> Show Password
				</div> 
				
				<div class="form-group">
					<label for="Address">Mobile Number</label>
					<input type="text" name="address" required placeholder="Mobile Number" required class="form-control form-control-lg">
				</div>
				
				<div class="form-group">
					<label for="exampleFormControlSelect1">Select User Role</label>	
					<select class="form-control" id="exampleFormControlSelect1" name="userRole">
						<option value="admin">Admin</option>
						<option value="inventory-Manager">Inventory Manager</option>
						<option value="manager">Manager</option>
					</select>
				</div>
				<br>
				<input type="submit" value="Register" class="btn btn-primary btn-block"><br>
			    
			</form>
	    </div>
	</div>
	
	<footer class="text-center text-lg-start bg-white text-muted">
	  <!-- Section: Social media -->
		<section class="d-flex justify-content-center p-4 border-bottom border-top">
		
			<!-- Right -->
			<div>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-facebook-f"></i></a>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-twitter"></i> </a>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-google"></i></a>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-instagram"></i></a>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-linkedin"></i></a>
			  <a href="" class="me-4 link-secondary"><i class="fab fa-github"></i></a>
			</div>
			<!-- Right -->
		</section>
		<!-- Section: Social media -->
	
		<!-- Section: Links  -->
		<section class="">
			<div class="container text-center text-md-start mt-5">
				<!-- Grid row -->
				<div class="row mt-3">
					<!-- Grid column -->
					<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
						<!-- Content -->
							<h6 class="text-uppercase fw-bold mb-4"><i class="fas fa-gem me-3 text-secondary"></i>Spare Bytes</h6>
						<p>
						  Spare Bytes is a trusted provider of computer spare parts for businesses and individuals alike. 
						  We offer a wide selection of high-quality parts at competitive prices, including motherboards, CPUs, hard drives, and more.
						</p>
					</div>
					<!-- Grid column -->
			
					<!-- Grid column -->
					<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">CPU</h6>
						<p><a href="#!" class="text-reset">Motherboards</a></p>
						<p><a href="#!" class="text-reset">RAM</a></p>
						<p><a href="#!" class="text-reset">Graphic cards</a></p>
						<p><a href="#!" class="text-reset">Storage</a></p>
					</div>
					<!-- Grid column -->
			
					<!-- Grid column -->
					<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4"> Useful links</h6>
						<p><a href="#!" class="text-reset">Pricing</a></p>
						<p><a href="#!" class="text-reset">Settings</a></p>
						<p><a href="#!" class="text-reset">Orders</a></p>
						<p><a href="#!" class="text-reset">Help</a></p>
					</div>
					<!-- Grid column -->
			
					<!-- Grid column -->
					<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
						<p><i class="fas fa-home me-3 text-secondary"></i>  Malabe, MB 10012, SL</p>
						<p><i class="fas fa-envelope me-3 text-secondary"></i>      info@sparebyte.com</p>
						<p><i class="fas fa-phone me-3 text-secondary"></i> +94 71 3446 678</p>
						<p><i class="fas fa-print me-3 text-secondary"></i> +94 76 1374 567</p>
					</div>
					<!-- Grid column -->
				</div>
				<!-- Grid row -->
			</div>
		</section>
		<!-- Section: Links  -->
	
		<!-- Copyright -->
		<div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
		  © 2023 Copyright Spare Bytes
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
	
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