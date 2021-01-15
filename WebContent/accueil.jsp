<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil-Encheres</title>
</head>
<body>

	<h3>ENI-Encheres</h3>
	<nav>
		<a href="/ENI-Encheres/ConnexionServlet">S'inscrire - Se connecter</a>
	</nav>
	<h3>Liste des enchères</h3>
	Filtres :
	<br>
	<form action="AccueilServlet" method="POST">
		<input type="text" name="filtre" value="${model.filtre}" size="40" placeholder="Le nom de l'article contient...">
		<br> <br> <label for="categories">Catégorie : </label> <select
			name="categories" id="categories">
			<option value="">--Choisissez une catégorie--</option>
			<option value="toutes">Toutes</option>
			<option value="informatique">Informatique</option>
			<option value="ameublement">Ameublement</option>
			<option value="vetement">Vêtement</option>
			<option value="autre">Sport&Loisirs</option>
		</select> <br> <br> <input type="submit" name="recherche"
			value="Rechercher">
	</form>
	<c:forEach var="e" items="${model.listEncheres}">
		<tr>
			<td>${e.article.nomArticle}</td>
			<td>Prix : ${e.article.miseAPrix}</td>
			<td>Fin de l'enchère : ${e.article.dateFinEncheres}</td>
			<td>Vendeur : ${e.article.nomArticle}</td>
		</tr>
	</c:forEach>



</body>
</html>