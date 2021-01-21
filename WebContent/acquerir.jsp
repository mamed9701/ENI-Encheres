<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  
<title>Acquerir - ENI Enchères</title>
</head>
<body>
<jsp:include page="logo.jsp"></jsp:include>
	<h2> Vous avez remporté l'enchère</h2><br><br>
	${model.articleVendu.nomArticle}<br><br>
	Description : ${model.articleVendu.description}<br><br>
	Meilleure offre : ${model.articleVendu.prixVente} pts<br>
	Mise à prix : ${model.articleVendu.miseAPrix} points<br><br>
	Retrait : ${model.retrait.rue}<br>
			${model.retrait.codePostal} ${model.retrait.ville}<br><br>
	Vendeur : ${model.enchere.utilisateur}<br>
	Télephone : ${model.enchere.utilisateur.telephone}<br><br>
	
	<form action="/ENI-Encheres/afficherEncheres" method="POST">
		<input type="submit" name="back" value="Back">
 	</form>

</body>
</html>