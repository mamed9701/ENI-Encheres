<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion-Encheres</title>
</head>
<body>
	<h1>ENI-Encheres</h1>

	<form action="AfficherEncheresServlet" method="POST">
		Identifiant : <input type="text" name="identifiant" value="${model.identifiant}"><br><br> 
		Mot de passe : <input type="text" name="mdp" value="${model.identifiant}"><br><br>
		<input type="submit" value="Connexion">
		<input type="checkbox" name="souvenir">Se souvenir de moi<br>
		<br> <a href="">Mot de passe oublié</a><br><br>
	</form>
	
		<form action="InscriptionServlet">
			<input type="submit" value="Créer un compte">
		</form>	
		


</body>
</html>