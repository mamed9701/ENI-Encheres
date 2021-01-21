<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil-Encheres</title>
</head>
<body>
<jsp:include page="logo.jsp"></jsp:include>
	<nav>
		<a href="/ENI-Encheres/afficherEncheres">Enchères</a>
		<a href="/ENI-Encheres/vendre-article">Vendre un article</a>
		<a href="/ENI-Encheres/afficher-utilisateur">Mon profil</a>
		<a href="/ENI-Encheres/login">Déconnexion</a>
	</nav>
	<h3>Liste des enchères</h3>
	Filtres :
	<br>
	<form action="/ENI-Encheres/accueil" method="POST">
		<input type="text" name="filtre" value="${model.filtre}" size="40"
			placeholder="Le nom de l'article contient..."> <br> <br>
		<label for="categories">Catégorie : </label> <select name="categories"
			id="categories">
			<c:forEach var="cat" items="${model.listCategories}">
				<option value="${fn:toLowerCase(cat.libelle)}">${cat.libelle}</option>
			</c:forEach>
		</select> <br> <br> <input type="submit" name="recherche"
			value="Rechercher"> <br> <br>
		<div>
			<input type="radio" name="choix" value="Achats">
			<label for="choixAchats">Achats</label><br>
			<tr>
				<td>
					<input type="checkbox" name="e_ouvertes" value="Encheres ouvertes">
					<label for="e_ouvertes">Encheres ouvertes</label><br> <br>
					<input type="checkbox" name="encheres" value="Mes encheres">
					<label for="encheres">Mes encheres</label><br> <br>
					<input type="checkbox" name="e_remportees" value="Mes encheres remportées">
					<label for="e_remportees">Mes encheres remportées</label><br> <br>
				</td>
			</tr><br> <br>
		</div>	
		
		<div>
			<input type="radio" name="choix" value="Mes ventes">
			<label for="choixVentes">Ventes</label><br>
			<tr>
				<td>
					<input type="checkbox" name="en_cours" value="Mes ventes en cours">
					<label for="en_cours">Mes ventes en cours</label><br> <br>
					
					<input type="checkbox" name="non_debutees" value="Ventes non débutées">
					<label for="non_debutees">Ventes non débutées</label><br> <br>
					
					<input type="checkbox" name="terminees" value="Ventes terminées">
					<label for="terminees">Ventes terminées</label><br> <br>
					
				</td>
			</tr>
		</div>	
	</form><br><br>
	<table border ="3">
		<c:forEach var="e" items="${model.listEncheres}">
			<tr>
				<td>${e.article.nomArticle}</td>
				<td>Prix : ${e.article.miseAPrix} pts</td>
				<td>Fin de l'enchère : ${e.article.dateFinEncheres}</td>
				<td>Vendeur : ${e.utilisateur.nom}</td>
			</tr>
		</c:forEach>
	</table>	
	

</body>
</html>