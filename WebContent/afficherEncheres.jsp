<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<title>Afficher enchères - ENI Enchères</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
	<a class="navbar-brand" href="/ENI-Encheres/accueil">ENI-Encheres</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/accueil">Encherès</a></li>
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/vendre-article">Vendre un article</a></li>
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/edit">Mon profil</a></li>
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/logout">Déconnexion</a></li>
		</ul>				
	</div>
</nav>
	<h3>Liste des enchères</h3>
	Filtres :
	<br>
	<form action="/ENI-Encheres/accueil" method="POST">
		<input type="text" name="filtre" value="${model.filtre}" size="40"
			placeholder="Le nom de l'article contient..."> <br> <br>
		<label for="categories">Catégorie : </label> <select name="categories"
			id="categories">
			<option value="toutes">Toutes</option>
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