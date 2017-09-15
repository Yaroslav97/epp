<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="signup" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="i18n" tagdir="/WEB-INF/tags" %>


<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Youth Fashion A Ecommerce Category Flat Bootstrap Responsive Website Template | Products :: w3layouts</title>
<link href="css/bootstrap-3.1.1.min.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Youth Fashion Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='//fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
<!-- start menu -->
<script src="js/bootstrap.min.js"></script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>

  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
				<div class="col-sm-4 logo">
					<h1><a href="index.jsp">Youth <span>Car Shop</span></a></h1>
				</div>
			<div class="col-sm-4 world">
					<div class="cart box_1">
						<a href="cart.jsp">
						<h3><div class="total">
							<span class="simpleCart_total"></span></div>
							<img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

					</div>
			</div>
			<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
					<p>Call me</p>
				</div>
			<div class="col-sm-2 search">
				<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
		<div class="container">
			<div class="head-top">
			<div class="n-avigation">

				<nav class="navbar nav_bottom" role="navigation">

				 <!-- Brand and toggle get grouped for better mobile display -->
				  <div class="navbar-header nav_2">
					  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
					  <a class="navbar-brand" href="#"></a>
				   </div>
				   <!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav nav_1">
							<li><a href="index.jsp">Home</a></li>
							<li class="dropdown mega-dropdown active">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Women<span class="caret"></span></a>
								<div class="dropdown-menu mega-dropdown-menu">
									<div class="container-fluid">
										<!-- Tab panes -->
										<div class="tab-content">
										  <div class="tab-pane active" id="men">
											<ul class="nav-list list-inline">
												<li><a href="women.html"><img src="images/t7.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="women.html"><img src="images/t8.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="women.html"><img src="images/t9.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="women.html"><img src="images/t11.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="women.html"><img src="images/t1.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="women.html"><img src="images/t12.jpg" class="img-responsive" alt=""/></a></li>
											</ul>
										  </div>
									   </div>
									</div>
									<!-- Nav tabs -->

								</div>
							</li>
							<li class="dropdown mega-dropdown active">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Men<span class="caret"></span></a>
								<div class="dropdown-menu mega-dropdown-menu">
									<div class="container-fluid">
										<!-- Tab panes -->
										<div class="tab-content">
										  <div class="tab-pane active" id="men1">
											<ul class="nav-list list-inline">
												<li><a href="men.html"><img src="images/t10.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="men.html"><img src="images/t2.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="men.html"><img src="images/t3.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="men.html"><img src="images/t4.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="men.html"><img src="images/t5.jpg" class="img-responsive" alt=""/></a></li>
												<li><a href="men.html"><img src="images/t6.jpg" class="img-responsive" alt=""/></a></li>
											</ul>
										  </div>

									   </div>
									</div>
									<!-- Nav tabs -->

								</div>
							</li>
							<li><a href="/OnlineShop/product">Products</a></li>
							<li><a href="account.jsp">Sign In</a></li>
							<li class="last"><a href="contact.html">Contact</a></li>
							<li class="last"> <i18n:i18n/> </a></li>


							 <c:if test = "${!empty sessionScope.login}">
                                   <signup:signup login="${sessionScope.login}" avatar="${sessionScope.avatar}"/>
                             </c:if>

						</ul>
					 </div><!-- /.navbar-collapse -->

				</nav>
			</div>


		<div class="clearfix"> </div>
			<!---pop-up-box---->
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<form action="#" method="post">
								<input type="submit" value="">
								<input type="text" name="search" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">

							</form>
						</div>
						<p>	Shopping</p>
					</div>
				</div>
				<script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});

						});
				</script>
	<!---->
		</div>
	</div>
</div>
<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: slideInLeft;">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Products</li>
			</ol>
		</div>
	</div>



<!--content -------------------------------------------------------------------------------------------------------- -->

     <!--

        <script src="http://code.jquery.com/jquery-latest.min.js"></script>

           <script>
             $(document).ready(function() {
                 $("#somebutton").click(function() {
                     servletCall();
                 });

             });
             function servletCall() {
             var productName=$('#name').val();
                 $.get("/OnlineShop/addCart", {name : productName}, function(result) {
                     $('#somediv').html(result + 'added to cart');
                 });
             };
           </script>

           -->

<div class="products">
	<div class="container">
		<h2>Products</h2>
		<div class="col-md-9">
			<div class="content-top1">

			<c:forEach items="${products}" var="items">

                <div class="col-md-4 col-md4">
                    <div class="col-md1 simpleCart_shelfItem">
                        <a href="single.html"><img class="img-responsive" src="${path}${items.image}" alt="" /></a>
                        <h3><a href="single.html">${items.name}</a></h3>
                        <div class="price">
                            <h5 class="item_price">$${items.price}</h5>

                            <!--   <a href="#" class="item_add">Add To Cart</a> -->

                            <script>
                                $(document).ready(function() {                                       
                                    $('#submit${items.id}').click(function(event) {                     
                                        var productName = $('#name${items.id}').val();                 
                                        $.get('/OnlineShop/addCart', {
                                            name: productName
                                        }, function(responseText) {                        
                                            $('#text').text(responseText);                            
                                        });                
                                    });            
                                });
                            </script>

                            <form id="form1${items.name}">
                                <input type="hidden" id="name${items.id}" value="${items.name}" />
                                <input class="item_add" type="button" id="submit${items.id}" value="Add to cart" />
                            </form>

                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>

            </c:forEach>

	     		<div class="col-md-4 col-md4">
					<div align="center" style="color: #107cef"><h3>${emptyContainer}</h3></div>
				</div>

				<!--  ---------------------------------------------------------------------------------------  -->

			<div class="clearfix"> </div>
			</div>
		</div>
		<div class="col-md-3 product-bottom">
			<!--categories-->

				 <div class=" rsidebar span_1_of_left">


				<form action="/OnlineShop/productItem" method="get">

				    <c:forEach var = "i" begin = "0" end = "${pageCount}">
				        <c:if test = "${empty filter}">
				            <a href="/OnlineShop/productItem?current_page=${current_page}&item_size=${size}&search=&price_from=&price_to=&subject=all&origin=all&sort_by=Name&next_page=${i}"> ${i} </a>
                        </c:if>

                        <c:if test = "${not empty filter}">
				            <a href="/OnlineShop/productItem?current_page=${current_page}&item_size=${size}&search=${filter.search}&price_from=${filter.priceFrom}&price_to=${filter.priceTo}&subject=${filter.subject}&origin=${filter.origin}&sort_by=${filter.sortBy}&next_page=${i}"> ${i} </a>
			            </c:if>
			          </c:forEach>

			    <input type="hidden" name="current_page" value="${current_page}">

				    <br>
				    <br>
				    <h4>item size:</h4>
                    <input type="text" name="item_size" value="${size}" placeholder="Item" >
                    <br>
                    <br>
                    <input type="text" name="search" value="${requestScope.filter.search}" placeholder="Search by name" >
                    <br>
                    <br>
                    <input type="text" name="price_from" value="${requestScope.filter.priceFrom}" placeholder="Price from" >
                    <input type="text" name="price_to" value="${requestScope.filter.priceTo}" placeholder="Price to" >
                    <br>
                    <br>
                    <h4>type:</h4>
                    <select name="subject">
                      <option value="all">All</option>
                      <option value="car">Car</option>
                      <option value="cabriolet">Cabriolet</option>
                      <option value="electrocar">Electrocar</option>
                      <option value="sportcar">Sportcar</option>
                    </select>
                    <br>
                    <br>
                    <h4>origin:</h4>
                    <select name="origin">
                        <option value="all">All</option>
                        <option value="USA">USA</option>
                        <option value="Germany">Germany</option>
                        <option value="UK">UK</option>
                        <option value="Italy">Italy</option>
                    </select>
                    <br>
                    <br>
                    <h4>sort by:</h4>
                    <select name="sort_by">
                        <option value="name">Name</option>
                        <option value="products.subject">Subject</option>
                        <option value="price">Price</option>
                        <option value="products.origin">Origin</option>
                    </select>
                    <br>
                    <br>
                    <input type="submit" value="Ok">

                </form>

					</div>
				<!--initiate accordion-->

<!--//menu-->
<!--seller-->


<!--//seller-->
<!--tag-->
				<div class="tag">
						<h3 class="cate">Tags</h3>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
						<div class="clearfix"> </div>
						</ul>
				</div>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//content-->
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-6 top-footer">
				<h3>Follow Us On</h3>
				<div class="social-icons">
					<ul class="social">
						<li><a href="#"><i></i></a> </li>
						<li><a href="#"><i class="facebook"></i></a></li>
						<li><a href="#"><i class="google"></i> </a></li>
						<li><a href="#"><i class="linked"></i> </a></li>
					</ul>
						<div class="clearfix"></div>
				 </div>
			</div>
			<div class="col-md-6 top-footer1">
				<h3>Newsletter</h3>
					<form action="#" method="post">
						<input type="text" name="email" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-md-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="products.html">Curabitur sapien</a></li>
						<li><a href="single.html">Dignissim purus</a></li>
						<li><a href="men.html">Tempus pretium</a></li>
						<li><a href="products.html">Dignissim neque</a></li>
						<li><a href="single.html">Ornared id aliquet</a></li>

					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="products.html">Dignissim purus</a></li>
						<li><a href="men.html">Curabitur sapien</a></li>
						<li><a href="single.html">Tempus pretium</a></li>
						<li><a href="men.html">Dignissim neque</a></li>
						<li><a href="products.html">Ornared id aliquet</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="products.html">Tempus pretium</a></li>
						<li><a href="single.html">Curabitur sapien</a></li>
						<li><a href="men.html">Dignissim purus</a></li>
						<li><a href="single.html">Dignissim neque</a></li>
						<li><a href="men.html">Ornared id aliquet</a></li>


					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>Address : 12th Avenue, 5th block, <span>Sydney.</span></li>
						<li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>Email : <a href="mailto:info@example.com">info@example.com</a></li>
						<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>Phone : +1234 567 567</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class"> © 2016 Youth Fashion . All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
			</div>
	</div>
</div>
<!--footer-->
</body>
</html>