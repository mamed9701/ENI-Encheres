<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>

<meta charset="UTF-8">
<title>Connexion - ENI Enchères</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 col-lg-6 offset-lg-3">
				
				<form action="/ENI-Encheres/login" method="POST" class="form-signin mt-5">
					<h1 class="h3 mb-3 font-weight-normal">Connexion utilisateur</h1>
					<c:if test="${error != null}">
			        	<div class="alert alert-danger" role="alert">
						  	${error}
						</div>       	
		        	</c:if>
					<label for="username" class="sr-only">Email address</label>
					<input type="text" id="username" name="user" value="${model.identifiant}" class="form-control mb-3" placeholder="Identifiant" required autofocus>
					<label for="password" class="sr-only">Password</label>
					<input type="password" id="password" name="pwd" value="${model.motDePasse}" class="form-control mb-3" placeholder="Mot de passe" required>
					
					<div class="checkbox mb-3">
					  <label>
					    <input type="checkbox" value="remember-me"> Se souvenir de moi
					  </label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
			    </form>
			    
				<a href="#" class="stretched-link">Mot de passe oublié</a> <br>
			    <a href="/ENI-Encheres/register">Créer un compte</a>
			</div>			
		</div>
	</div>
 
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>