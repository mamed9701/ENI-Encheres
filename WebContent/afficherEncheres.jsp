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
<div class="container">
	<h1 class="display-4">Liste des enchères</h1>
	<p>
	  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filters" aria-expanded="false" aria-controls="filters">
	    Filtres
	  </button>
	</p>
	<div class="collapse mb-2" id="filters">
	  <div class="card card-body">
	    <form action="/ENI-Encheres/accueil" method="POST">
		    <div class="form-group row">
	             <div class="col-sm-6">
	                <input type="text" class="form-control" name="filtre" id="filtre"
					value="${model.filtre}"
					placeholder="Le nom de l'article contient...">
	             </div>
	             <div class="col-sm-6">
	                <select class="form-control" id="categories" name="categories">
				      	<option value="toutes">Toutes les catégories</option>
						<c:forEach var="cat" items="${model.listCategories}">
							<option value="${fn:toLowerCase(cat.libelle)}">${cat.libelle}</option>
						</c:forEach>
				    </select>
	             </div>
	        </div>
	        
			<div class="form-group row">
				<div class="col-sm-6">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					  <li class="nav-item">
					    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-achats" role="tab" aria-controls="pills-achats" aria-selected="true">Achats</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-ventes" role="tab" aria-controls="pills-ventes" aria-selected="false">Ventes</a>
					  </li>
					</ul>
					<div class="tab-content ml-5" id="pills-tabContent">
					  <div class="tab-pane fade show active" id="pills-achats" role="tabpanel" aria-labelledby="pills-achats-tab">
					  		<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="encheres-ouvertes">
							  <label class="form-check-label" for="encheres-ouvertes">
							    enchères ouvertes
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="mes-encheres">
							  <label class="form-check-label" for="mes-encheres">
							    mes enchères
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="encheres-remportes">
							  <label class="form-check-label" for="encheres-remportes">
							    mes enchères remportées
							  </label>
							</div>
					  </div>
					  <div class="tab-pane fade" id="pills-ventes" role="tabpanel" aria-labelledby="pills-ventes-tab">
					  	<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="en-cours">
							  <label class="form-check-label" for="en-cours">
							    mes ventes en cours
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="non-debutees">
							  <label class="form-check-label" for="non-debutees">
							    ventes non débutées
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="terminees">
							  <label class="form-check-label" for="terminees">
							   ventes terminées
							  </label>
							</div>
					  </div>
					</div>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary">Rechercher</button>
		</form>
	  </div>
	</div>
    <div class="row mb-2">
		<c:forEach var="e" items="${model.listEncheres}">
			<div class="col-md-6">
	          <div class="card flex-md-row mb-4 box-shadow h-md-250">
	            <div class="card-body d-flex flex-column align-items-start">	              
	              <h5 class="mb-0">
	                <a class="text-dark" href="#">${e.article.nomArticle}</a>
	              </h5>	
	              <p class="mb-0">Prix : ${e.article.miseAPrix}</p>	
	              <p class="mb-0">Fin de l'enchère : ${e.article.dateFinEncheres}</p>	
	              <p class="mb-0">Vendeur : <a href="/ENI-Encheres/afficher-utilisateur">${e.utilisateur.pseudo}</a></p>	              
	            </div>
	            <img class="card-img-right flex-auto d-none d-md-block" src="img/placeholder.png" alt="Thumbnail [200x250]">
	          </div>
	        </div>
		</c:forEach>
        
      </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>