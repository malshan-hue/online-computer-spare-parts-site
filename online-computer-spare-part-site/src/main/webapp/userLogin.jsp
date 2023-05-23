<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    
    <style type="text/css">
    
		.divider:after,
		.divider:before {
			content: "";
			flex: 1;
			height: 1px;
			background: #eee;
			}
		.h-custom {
			height: calc(100% - 73px);
			}
		@media (max-width: 450px) {
				.h-custom {
				height: 100%;
				}
			}
    	
    </style>
    
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    
    <link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
    
    <title>Spare Byte Computer Shop</title>
    
</head>

<body>

	<% String status = (String) session.getAttribute("status"); %>

	<input type="hidden" id="status" value="<%=status%>">
	
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div class="row d-flex justify-content-center align-items-center h-500">
				<div class="col-md-9 col-lg-6 col-xl-5">
				  <img src="resources/loginLogo.png" class="img-fluid">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="<%= request.getContextPath()%>/UserLoginServlet" method="post">
					
						<br><br><br><br>
						
							  	<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" class="form-control form-control-lg" placeholder="Enter Username" name="username"/>
							<label class="form-label" for="form3Example3">Username</label>
						</div>
						
						<!-- Password input -->
						<div class="form-outline mb-3">
							<input type="password" class="form-control form-control-lg" placeholder="Enter password" name="password"/>
							<label class="form-label" for="form3Example4">Password</label>
						</div>
						
						<div class="d-flex justify-content-between align-items-center">
						  <!-- Checkbox -->
							<div class="form-check mb-0">
							  <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
							  <label class="form-check-label" for="form2Example3"> Remember me</label>
							</div>
							<a href="#!" class="text-body">Forgot password?</a>
						</div>
						
						<div class="text-center text-lg-start mt-4 pt-2">
							  <input type="submit" value="Login" class="btn btn-primary btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;">
							<p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="signup.jsp" class="link-danger">Register</a></p>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="d-flex flex-column flex-md-row justify-content-center align-items-center py-4 px-4 px-xl-5 bg-primary">
	  <!-- Copyright -->
			<div class="text-white text-center">
				Copyright © 2023. All rights reserved.
			</div>
		<!-- Copyright -->
		</div>
	</section>
	
	<script type="text/javascript">
		
		var status = document.getElementById("status").value;
		
		if(status == "failed"){
			
			Swal.fire({
				  position: 'center',
				  icon: 'error',
				  title: 'Check username or password',
				  showConfirmButton: false,
				  timer: 1500
				})
		}
		
	</script>
	
</body>
</html>