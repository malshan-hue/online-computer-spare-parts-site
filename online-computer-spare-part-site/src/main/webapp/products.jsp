<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
<%@ page import = "com.sparebyte.models.Product" %>
<%@ page import = "com.sparebyte.service.product.IProductService" %>
<%@ page import = "com.sparebyte.service.product.ProductServiceImpl" %>
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
		.container{
			margin-top: 100px;
			margin-bottom: 100px;
		}
		
		.card-img-top{
			height: 250px;
			object-fit: cover;
		}
		
	</style>
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
	<title>Products</title>
	
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
						<h1 class="mb-3">Latest Products</h1>
						<h4 class="mb-3">Computer Spare Part Sellers</h4>
						<h4 class="mb-3">Explore Digital Realm</h4>
						<a class="btn btn-outline-light btn-lg" href="productList.jsp" role="button">Buy now</a>
						<br><br><br><br>
					</div>
				</div>
			</div>
		</div>
	<!-- Background image -->
	</header>
	
	<div class="container">
		<div class="row">
			<div class="col-8 offset-2">
				  <div class="input-group">
					    <input type="text" id="searchInput" class="form-control" placeholder="Search products">
					    <button class="btn btn-primary" onclick="searchProducts()">Search</button>
				  </div>
			</div>
		</div>
	</div>

	
	<div class="container">
		<%	
			
			IProductService productService = new ProductServiceImpl();
			ArrayList<Product> arrayList = productService.getProducts();
		
			for(Product product : arrayList){
					
		%>		
		
			<% if(arrayList.indexOf(product) % 3 == 0){ %>		
				<div class="row">
			<% } %>
	
						<div class="col-4">
							<div class="card">
								<img class="card-img-top" src="./resources/productImages/<%=product.getProductImagePath()%>" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title text-center"><%= product.getProductName() %></h5>
									<h6 class="card-title text-center"><%= product.getProductCategory() %></h6>
									<h5 class="card-text text-center">Price : Rs.<%= product.getProductPrice() %></h5>
								</div>
								<div class="card-footer text-center">
									<form action="<%= request.getContextPath()%>/AddCartServlet" method="post">
										<div class="form-group">
											<input type="hidden" value="<%= userID %>" name="userID">
											<input type="hidden" value="<%= product.getProductName() %>" name="productName">
											<input type="hidden" value="<%= product.getProductPrice() %>" name="amount">
											<input type="submit" value="Add to Cart" class="btn btn-outline-primary">
										</div>
									</form>
									<br>
									<button class="btn btn-outline-primary" onclick="view('<%=product.getProductImagePath()%>' , '<%= product.getProductDec() %>', '<%= product.getProductBrand() %>', '<%= product.getProductModel()  %>', '<%= product.getProductStock() %>')">view</button>
								</div>
							</div>
						</div>
			<% if ((arrayList.indexOf(product) + 1) % 3 == 0 || arrayList.indexOf(product) == arrayList.size() - 1 ) {%>
				</div>
				<br>
			<% } %>
		<% } %>
	</div>
	
		<!-- Footer -->
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
	
	<script type="text/javascript">
		
		function view(path, description, brand, model, stock){
			
			Swal.fire({
				  title: "Brand: " + brand + " " + "Model: " + model,
				  html: "<p>" + description + "</p><p>Stock: " + stock + "</p>",
				  footer: "Stock: " + stock,
				  imageUrl: './resources/productImages/'+path,
				  imageWidth: 400,
				  imageHeight: 200,
				})
		}
		
		function searchProducts() {
			  var input, filter, cards, card, i, txtValue;
			  input = document.getElementById("searchInput");
			  filter = input.value.toUpperCase();
			  cards = document.getElementsByClassName("col-4");

			  for (i = 0; i < cards.length; i++) {
			    card = cards[i];
			    txtValue = card.textContent || card.innerText;

			    if (txtValue.toUpperCase().indexOf(filter) > -1) {
			      card.style.display = "";
			    } else {
			      card.style.display = "none";
			    }
			  }
			}

	</script>
	
</body>

</html>