<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center">
		<h1>Main Page</h1>
	</div>
	<br><br>
	<div style="background:black; padding:10px; color: white; text-align:right">
		<b>Username:</b>ha07
	</div>
	<br><br>
	<hr>
	<div>
		<form action=create-account >
			<h3>Create Account</h3>
			<table>	
				<tr>
					<td>Select Account Type:</td>
					<td><select name="account_type">
						<option value="saving">Saving</option>
						<option value="current">Current/Checking</option>
						<option value="isa">ISA (individual savings account)</option>
					</select></td>
				</tr>
				<tr>
					<td>Enter Amount:</td>
					<td><input type="text" name="amount"/></td>
				</tr>
			</table>
			<button type="submit">Create New Account</button>
     	</form>
	</div>
	<hr>
	<div>
		<form action="transfer-amount" >
			<h3>Transfer Amount</h3>
			<table>	
				<tr>
					<td>Select Account Type:</td>
					<td><select name="account_type">
						<option value="saving">Saving</option>
						<option value="current">Current/Checking</option>
						<option value="isa">ISA (individual savings account)</option>
					</select></td>
				</tr>
				<tr>
					<td>Enter Account Number:</td>
					<td><input type="text" name="account_number"/></td>
				</tr>
				<tr>
					<td>Enter Amount to Transfer:</td>
					<td><input type="text" name="amount_to_transfer"/></td>
				</tr>
			</table>
			<button type="submit">Transfer Amount</button>
     	</form>
	</div>
</body>
</html>