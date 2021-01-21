<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<title>Ma vente - ENI Enchères</title>
</head>
<body>

	<jsp:include page="logo.jsp"></jsp:include>

	<h2>${model.profilUtilisateur.pseudo}</h2> <h2>a remporté l'enchère</h2><br><br>
	${model.articleVendu.nomArticle}<br><br>
	Description : ${model.articleVendu.description}<br><br>
	Meilleure offre : ${model.articleVendu.prixVente}pts par ${model.profilUtilisateur.pseudo}<br>
	Mise à  prix : ${model.articleVendu.miseAPrix} points<br><br>
	Fin de l'enchère : ${model.articleVendu.dateFinEncheres}<br><br>
	Retrait : ${model.retrait.rue}<br>
			${model.retrait.codePostal} ${model.retrait.ville}<br><br>
				
	Vendeur : ${model.enchere.utilisateur}<br><br>
	
	<form action="/ENI-Encheres/finEnchere" method="POST">
		<input type="submit" name="done" value="Retrait effectué">
 	</form>
	
	
	
	
	

</body>
</html>