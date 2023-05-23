<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.sparebyte.models.User" %>
<%@ page import = "com.sparebyte.service.user.IUserService" %>
<%@ page import = "com.sparebyte.service.user.UserServiceImpl" %>

<%@ page import = "java.util.ArrayList" %>
    
<% String logoutUrl = "logout.jsp"; %>
    
<% 	
	String userID = (String) session.getAttribute("userID");
	String username = (String) session.getAttribute("user");
	String role = (String) session.getAttribute("role");
	
	String index = "";
	
	if(role.equals("admin")){
		index = "indexAdmin.jsp";
	}
	
	if (role.equals("inventory-Manager")){
		index = "indexInventoryManager.jsp";
	}
	
	if(role.equals("manager")){
		index = "indexManager.jsp";
	}
	
	if(role.equals("user")){
		index = "index.jsp";
	}
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

		
		<style>
			body{
				background-color:#f2f6fc;
				color:#69707a;
			}
			.img-account-profile {
			    height: 10rem;
			}
			.rounded-circle {
			    border-radius: 50% !important;
			}
			.card {
			    box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
			    height: 350px;
			}
			.card .card-header {
			    font-weight: 500;
			}
			.card-header:first-child {
			    border-radius: 0.35rem 0.35rem 0 0;
			}
			.card-header {
			    padding: 1rem 1.35rem;
			    margin-bottom: 0;
			    background-color: rgba(33, 40, 50, 0.03);
			    border-bottom: 1px solid rgba(33, 40, 50, 0.125);
			}
			.form-control, .dataTable-input {
			    display: block;
			    width: 100%;
			    padding: 0.875rem 1.125rem;
			    font-size: 0.875rem;
			    font-weight: 400;
			    line-height: 1;
			    color: #69707a;
			    background-color: #fff;
			    background-clip: padding-box;
			    border: 1px solid #c5ccd6;
			    -webkit-appearance: none;
			    -moz-appearance: none;
			    appearance: none;
			    border-radius: 0.35rem;
			    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
			    
			}
			
		</style>
		
		<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    
		<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
		
		<title>Profile</title>
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
						<li class="nav-item"> <a class="nav-link" href="#">Profile</a></li>
						<li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About us</a></li>
						<li class="nav-item"><a class="nav-link" href="viewCart.jsp">View Cart</a></li>
						<li class="nav-item"><a class="nav-link" href="signup.jsp">Signup</a></li>
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
						<h1 class="mb-3">Spare Bytes</h1>
						<h4 class="mb-3">Computer Spare Part Sellers</h4>
						<h4 class="mb-3">Explore Digital Realm</h4>
						<a class="btn btn-outline-light btn-lg" href="products.jsp" role="button">Buy now</a>
						<br><br><br><br>
					</div>
				</div>
			</div>
		</div>
	<!-- Background image -->
	</header>
	
	<div class="container-xl px-4 mt-4">
	    <div class="row">
	        <div class="col-xl-4">
	            <!-- Profile picture card-->
	            <div class="card mb-4 mb-xl-0">
	                <div class="card-header">Profile Picture</div>
	                <div class="card-body text-center">
	                    <!-- Profile picture image-->
                    	<img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png">
	                    <!-- Profile picture help block-->
	                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
	                    <!-- Profile picture upload button-->
                    	<button class="btn btn-primary" type="submit">Upload new image</button>

	                </div>
	            </div>
	        </div>
	        <div class="col-xl-8">
	            <!-- Account details card-->
	            <div class="card mb-4">
	                <div class="card-header">Account Details</div>
	                <div class="card-body">
	                
						<%
	                		IUserService iUserService = new UserServiceImpl();
	                		User user = iUserService.getUserByName(username);
	                	         %>
	                	
		                    <form action="<%= request.getContextPath()%>/UpdateProfileServlet" method="POST">
		                    	<input class="form-control"  type="hidden"  value="<%= userID %>"  name="userID">
		                    	
		                        <!-- Form Row-->
		                        <div class="row gx-3 mb-3">
		                            <!-- Form Group (first name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="inputFirstName">User Name</label>
		                                <input class="form-control"  type="text"  value="<%= user.getUserName() %>"  name="userName">
		                            </div>
		                            <!-- Form Group (last name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="inputLastName">Password</label>
		                                <input class="form-control"  type="password" id="password" name="password" value="<%= user.getPassword() %>" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{8,}" title="Must contain: at least one number, one uppercase letter, one lowercase letter, one special character, and 8 or more characters">
		                                <input type="checkbox" onclick="showPassword()"> <label class="small mb-1" for="inputLastName">Show Password</label>
		                            </div>
		                        </div>
		                        <!-- Form Row        -->
		                        <div class="row gx-3 mb-3">
		                            <!-- Form Group (organization name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="inputOrgName">Email</label>
		                                <input class="form-control" type="email" value="<%= user.getEmail() %>" required aria-describedby="emailHelp" name="email">
		                            </div>
		                            <!-- Form Group (location)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="inputLocation">Mobile Number</label>
		                                <input class="form-control"  type="text" value="<%= user.getMobileNo() %>" name="mobileNo">
		                            </div>
		                        </div>
		                        <!-- Save changes button-->
		                        <input type="submit" value="Save Changes" class="btn btn-primary">
		                    </form>
	                </div>
	            </div>
	        </div>
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