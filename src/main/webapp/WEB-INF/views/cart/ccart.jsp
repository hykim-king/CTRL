<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid mt-5">
		<h2 class="mb-5 text-center">Shopping Cart</h2>
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="table-responsive">
					<table id="myTable" class="table">
						<thead>
							<tr>
								<th>Product</th>
								<th>Name</th>
								<th>Qty</th>
								<th>Price</th>
								<th class="text-right"><span id="amount" class="amount">Amount</span>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="product-img">
										<div class="img-prdct">
											<img
												src="https://image.flaticon.com/icons/png/512/3144/3144467.png">
										</div>
									</div>
								</td>
								<td>
									<p>Product One</p>
								</td>
								<td>
									<div class="button-container">
										<button class="cart-qty-plus" type="button" value="+">+</button>
										<input type="text" name="qty" min="0" class="qty form-control"
											value="0" />
										<button class="cart-qty-minus" type="button" value="-">-</button>
									</div>
								</td>
								<td><input type="text" value="72"
									class="price form-control" disabled></td>
								<td align="right">$ <span id="amount" class="amount">0</span></td>
							</tr>
							<tr>
								<td>
									<div class="product-img">
										<div class="img-prdct">
											<img
												src="https://image.flaticon.com/icons/png/512/3144/3144467.png">
										</div>
									</div>
								</td>
								<td>
									<p>Product Two</p>
								</td>
								<td>
									<div class="button-container">
										<button class="cart-qty-plus" type="button" value="+">+</button>
										<input type="text" name="qty" min="0" class="qty form-control"
											value="0" />
										<button class="cart-qty-minus" type="button" value="-">-</button>
									</div>
								</td>
								<td><input type="text" value="125"
									class="price form-control" disabled></td>
								<td align="right">$ <span id="amount" class="amount">0</span></td>
							</tr>
							<tr>
								<td>
									<div class="product-img">
										<div class="img-prdct">
											<img
												src="https://image.flaticon.com/icons/png/512/3144/3144467.png">
										</div>
									</div>
								</td>
								<td>
									<p>Product Three</p>
								</td>
								<td>
									<div class="button-container">
										<button class="cart-qty-plus" type="button" value="+">+</button>
										<input type="text" name="qty" min="0" class="qty form-control"
											value="0" />
										<button class="cart-qty-minus" type="button" value="-">-</button>
									</div>
								</td>
								<td><input type="text" value="250"
									class="price form-control" disabled></td>
								<td align="right">$ <span id="amount" class="amount">0</span></td>
							</tr>
							<tr>
								<td>
									<div class="product-img">
										<div class="img-prdct">
											<img
												src="https://image.flaticon.com/icons/png/512/3144/3144467.png">
										</div>
									</div>
								</td>
								<td>
									<p>Product Four</p>
								</td>
								<td>
									<div class="button-container">
										<button class="cart-qty-plus" type="button" value="+">+</button>
										<input type="text" name="qty" min="0" class="qty form-control"
											value="0" />
										<button class="cart-qty-minus" type="button" value="-">-</button>
									</div>
								</td>
								<td><input type="text" value="300"
									class="price form-control" disabled></td>
								<td align="right">$ <span id="amount" class="amount">0</span></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4"></td>
								<td align="right"><strong>TOTAL = $ <span
										id="total" class="total">0</span></strong></td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>