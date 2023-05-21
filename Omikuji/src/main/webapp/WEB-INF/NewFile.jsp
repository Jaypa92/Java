<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
	<div class="form" >
		<h1>Send An Omikuji</h1>
		<form action="/omikuji/processing" method="POST" >
			<div>	
				<label>Pick any number from 5 to 25</label>
				<input type="number" max="25" min="5" name="number" />
			</div>
			<div>
				<label>Enter the name of any city</label>
				<input type="text" name="city" />
			</div>
			<div>
				<label>Enter the name of any real person</label>
				<input type="text" name="person" />
			</div>
			<div>
				<label>Enter professional endeavor or hobby</label>
				<input type="text" name="hobby" />
			</div>
			<div>
				<label>Enter any type of living thing</label>
				<input type="text" name="thing" />
			</div>
			<div>
				<label>Say something nice to someone</label>
				<textarea name="message" ></textarea>
			</div>
			<p><b>Send and show a friend!</b></p>
			<button type="submit" >Send</button>
		</form>
	</div>
</body>
</html>