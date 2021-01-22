<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="UTF-8">

<title>Profil - ENI Enchères</title>
</head>
<body>

	<jsp:include page="logo.jsp"></jsp:include>

	<div class="container">
		<div class="row mt-5">
			<div class="col-sm-3">
				<label for="pseudo">Pseudo : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.pseudo}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Nom : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.nom}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Prénom : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.prenom}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Email : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.email}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Téléphone : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.telephone}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Rue : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.rue}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Code Postal : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.codePostal}" disabled>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-3">
				<label for="pseudo">Ville : </label>
			</div>
			<div class="col-sm-9">
				<input type="text" name="pseudo" id="pseudo" class="form-control"
					placeholder="Pseudo" value="${model.utilisateur.ville}" disabled>
			</div>
		</div>
		<c:if test="${currentUser != null}">
			<div class="row mt-5">
				<div class="col-sm-4 offset-lg-4">
					<a class="btn btn-warning px-4" href="/ENI-Encheres/edit">Modifier</a>
				</div>
			</div>
		</c:if>
	</div>
  
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>
