<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
	<link href="<c:url value='../../template/css/bootstrap.min.css'/>" rel="stylesheet" >
	<link href="<c:url value='../../template/css/font-awesome.min.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/prettyPhoto.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/price-range.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/animate.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/main.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/responsive.css'/>" rel="stylesheet">
	<!--[if lt IE 9]>
    <script src="<c:url value='../../template/js/html5shiv.js'/>"></script>
    <![endif]-->
</head><!--/head-->

<body>
	<jsp:include page="../../common/web/header.jsp"/>
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="name" style="text-align: center">Name</td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${listLineBook}">
					<tr>
						<td class="cart_product">
							<img  width="100" height="120" src="${item.itemBook.imageUrl}" alt=""/>
						</td>
						<td class="name">
							<p style="font-size:x-large; text-align: center">
								${item.itemBook.book.title}
							</p>
						</td>
						<td class="cart_price">
							<p>${item.itemBook.price}</p>
						</td>
						<td class="cart_quantity">
							<div class="cart_quantity_button">
								<a class="cart_quantity_up" href="/change-quantity?action=inc&id=${item.id}&type=book&quantity=${item.quantity}"> + </a>
								<input class="cart_quantity_input" type="text" name="quantity" value="${item.quantity}" autocomplete="off" size="2">
								<a class="cart_quantity_down" href="/change-quantity?action=dec&id=${item.id}&type=book&quantity=${item.quantity}"> - </a>
							</div>
						</td>
						<td class="cart_total">
							<p class="cart_total_price"> ${item.itemBook.price*item.quantity}</p>
						</td>
						<td class="cart_delete">
							<a class="cart_quantity_delete" href="/change-quantity?action=del&id=${item.id}&type=book&quantity=${item.quantity}"><i class="fa fa-times"></i></a>
						</td>
					</tr>
					</c:forEach>
					<c:forEach var="item" items="${listLineClothes}">
						<tr>
							<td class="cart_product">
								<img  width="100" height="120" src="${item.itemClothes.imageUrl}" alt=""/>
							</td>
							<td class="name">
								<p style="font-size:x-large; text-align: center">
										${item.itemClothes.clothes.name}
								</p>
							</td>
							<td class="cart_price">
								<p>${item.itemClothes.price}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="/change-quantity?action=inc&id=${item.id}&type=clothes&quantity=${item.quantity}"> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="${item.quantity}" autocomplete="off" size="2">
									<a class="cart_quantity_down" href="/change-quantity?action=dec&id=${item.id}&type=clothes&quantity=${item.quantity}"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"> ${item.itemClothes.price*item.quantity}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="/change-quantity?action=del&id=${item.id}&type=clothes&quantity=${item.quantity}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_option">
							<li>
								<input type="checkbox">
								<label>Use Coupon Code</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Use Gift Voucher</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Estimate Shipping & Taxes</label>
							</li>
						</ul>
						<ul class="user_info">
							<li class="single_field">
								<label>Country:</label>
								<select>
									<option>United States</option>
									<option>Bangladesh</option>
									<option>UK</option>
									<option>India</option>
									<option>Pakistan</option>
									<option>Ucrane</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>

							</li>
							<li class="single_field">
								<label>Region / State:</label>
								<select>
									<option>Select</option>
									<option>Dhaka</option>
									<option>London</option>
									<option>Dillih</option>
									<option>Lahore</option>
									<option>Alaska</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>

							</li>
							<li class="single_field zip-field">
								<label>Zip Code:</label>
								<input type="text">
							</li>
						</ul>
						<a class="btn btn-default update" href="">Get Quotes</a>
						<a class="btn btn-default check_out" href="">Continue</a>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span>${cart.totalPrice}</span></li>
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span>${cart.totalPrice}</span></li>
						</ul>
							<a class="btn btn-default update" href="">Update</a>
							<a class="btn btn-default check_out" href="">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

	<jsp:include page="../../common/web/footer.jsp"/>

	<script src="<c:url value='../../template/js/jquery.js'/>"></script>
	<script src="<c:url value='../../template/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.scrollUp.min.js'/>"></script>
	<script src="<c:url value='../../template/js/price-range.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.prettyPhoto.js'/>"></script>
	<script src="<c:url value='../../template/js/main.js'/>"></script>
</body>
</html>
