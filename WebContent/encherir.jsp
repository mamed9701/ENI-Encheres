<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<title>Détail vente - ENI Enchères</title>

</head>
<body>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<h2>Détail vente</h2>		
		</div>
		<div class="row mt-3">
			<div class="col-4">
				<img class="img-fluid" src="img/article-img.png"
					alt="Thumbnail [400x400]">
			</div>
			<div class="col-8">
				<div class="form-group row">
					<div class="col-6">
						<h2>${model.article.nomArticle}</h2>				
					</div>
				</div>
				<div class="form-group row">
					<label for="description" class="col-3 col-form-label">Description :</label>					
					<div class="col-6">
						${model.article.description}
					</div>
				</div>
				<div class="form-group row">
					<label for="categories" class="col-3 col-form-label">Categorie
						:</label>
					<div class="col-6">
						${model.article.categorie.libelle}							
					</div>
				</div>
				
				<div class="form-group row">
					<label for="prix" class="col-3 col-form-label">Meilleure offre :</label>
					<div class="col-6">
						${model.article.prixVente}
					</div>
				</div>
				<div class="form-group row">
					<label for="prix" class="col-3 col-form-label">Mise à prix :</label>
					<div class="col-6">
						${model.article.miseAPrix}
					</div>
				</div>
				
				<div class="form-group row">
					<label for="date-fin" class="col-3 col-form-label">Fin de l'enchère :</label>
					<div class="col-6">
						${model.article.dateFinEncheres}
					</div>
				</div>
				
				<div class="form-group row">
					<label for="date-fin" class="col-3 col-form-label">Retrait :</label>
					<div class="col-6">
						${model.user.rue} <br> ${model.user.codePostal} ${model.user.ville}
					</div>
				</div>
				
				<div class="form-group row">
					<label for="date-fin" class="col-3 col-form-label">Vendeur :</label>
					<div class="col-6">
						${model.article.utilisateur.pseudo}
					</div>
				</div>

				<form action="/ENI-Encheres/encherir" method="POST">
					<div class="form-group row mt-3">
							<label for="proposition" class="col-3 col-form-label">Ma proposition :</label>
							<div class="col-6">
								<input type="number" id="proposition" name="proposition" class="form-control" value="${model.maProposition}" min=0>
							</div>
							<div class="col-3">
								<button name="submit" type="submit" class="btn btn-primary">Encherir</button>	
							</div>
					</div>
				 	
			 	</form>
			</div>
		</div>

	</div>
	
</body>
</html>