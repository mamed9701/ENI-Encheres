<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novelle vente - ENI Enchères</title>
</head>
<body>
	<h2>Nouvelle vente</h2>
	<c:if test="${success != null}">
      	<div class="alert alert-success" role="alert">
	  		${success}
		</div>       	
   	</c:if>
	<form action="/ENI-Encheres/vendre-article" method="POST">
		Article : <input type="text" name="nom"><br><br>
		<label for="description">Description : </label><br>
		<textarea rows="5" cols="20" name="description" id="description"></textarea><br><br>
		 <label for="categories">Catégorie : </label>
		 <select name="categories" id="categories">
			<c:forEach var="cat" items="${model.listCategories}">
				<option value="${fn:toLowerCase(cat.libelle)}">${cat.libelle}</option>
			</c:forEach>
		</select> <br> <br>
		Photo de l'article : <input type="file" name="photo_profil" id="file"><br><br>
		Mise à prix : <input type="number" name="prix" min="0"><br><br>
		Début de l'enchère : <input type="date" name="debut_e" value="${model.article.dateDebutEncheres}"><br><br>
		Fin de l'enchère : <input type="date" name="fin_e" value="${model.article.dateFinEncheres}"><br><br>
		<div>
			<fieldset>
				 <legend>Retrait</legend>
				 Rue : <input type="text" name="rue_profil" value="${model.utilisateur.rue}"><br><br>
				 Code Postal : <input type="text" name="cdp_profil" value="${model.utilisateur.codePostal}"><br><br>
				 Ville : <input type="text" name="ville_profil" value="${model.utilisateur.ville}"><br><br>
			</fieldset><br><br>
		</div>
		<input type="submit" name="save" value="Enregistrer">
	</form><br>
	
	<form action="/ENI-Encheres/accueil" method="POST">
		<input type="submit" name="cancel" value="Annuler">
	</form>
</body>
</html>