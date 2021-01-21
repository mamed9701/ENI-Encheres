<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="header.jsp"></jsp:include>
<title>Novelle vente - ENI Enchères</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<h2>Nouvelle vente</h2>
			<c:if test="${success != null}">
				<div class="alert alert-success" role="alert">${success}</div>
			</c:if>
		</div>
		<div class="row mt-3">
			<div class="col-4">
				<img class="img-fluid" src="img/article-img.png"
					alt="Thumbnail [400x400]">
			</div>
			<div class="col-8">
				<form action="/ENI-Encheres/vendre-article" method="POST">
					<div class="form-group row">
						<label for="nom" class="col-3 col-form-label">Article :</label>
						<div class="col-6">
							<input id="nom" name="nom" placeholder="Nom" type="text"
								class="form-control" value="${model.article.nom}" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="description" class="col-3 col-form-label">Description
							:</label>
						<div class="col-6">
							<textarea id="description" name="description" cols="40" rows="5"
								class="form-control" required>${model.article.nom}</textarea>
						</div>
					</div>
					<div class="form-group row">
						<label for="categories" class="col-3 col-form-label">Categorie
							:</label>
						<div class="col-6">
							<select id="categories" name="categories" class="custom-select"
								required>
								<c:forEach var="cat" items="${model.listCategories}">
									<option value="${fn:toLowerCase(cat.libelle)}">${cat.libelle}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="photo" class="col-3 col-form-label">Photo de
							l'article :</label>
						<div class="col-6">
							<input type="file" name="photo_profil" id="file"
								class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="prix" class="col-3 col-form-label">Mise à prix
							:</label>
						<div class="col-6">
							<input id="prix" name="prix" type="number" min="0"
								value="${model.article.prixVente}" class="form-control" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="date-debut" class="col-3 col-form-label">Début
							de l'enchère</label>
						<div class="col-6">
							<input id="date-debut" name="debut_e" type="date"
								value="${model.article.dateDebutEncheres}" class="form-control"
								required>
						</div>
					</div>
					<div class="form-group row">
						<label for="date-fin" class="col-3 col-form-label">Fin de
							l'enchère :</label>
						<div class="col-6">
							<input id="date-fin" name="fin_e" type="date"
								value="${model.article.dateFinEncheres}" class="form-control"
								required>
						</div>
					</div>
					
					<div class="card col-10">
						<h5 class="card-header">Retrait</h5>
						<div class="card-body">
							<div class="form-group row">
							<label for="rue" class="col-3 col-form-label">Rue :</label>
							<div class="col-6">
								<input id="rue" name="rue_profil" type="text"
									class="form-control" value="${model.utilisateur.rue}" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="code-postal" class="col-3 col-form-label">Code
								postal :</label>
							<div class="col-6">
								<input id="code-postal" name="cdp_profil" type="text"
									class="form-control" value="${model.utilisateur.codePostal}"
									required>
							</div>
						</div>
						<div class="form-group row">
							<label for="ville" class="col-3 col-form-label">Ville :</label>
							<div class="col-6">
								<input id="ville" name="ville_profil" type="text"
									class="form-control" value="${model.utilisateur.ville}"
									required>
							</div>
						</div>
						</div>
					</div>

					<div class="form-group row mt-3">
						<div class="col-2">
							<button name="submit" type="submit" class="btn btn-primary">Enregistrer</button>
						</div>
						<div class="col-2">
							<a class="btn btn-warning px-4 float-right" href="/ENI-Encheres/accueil">Annuler</a>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>