<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="header.jsp"></jsp:include>

<title>Accueil - ENI Enchères</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
	<h2>ENI-Encheres</h2>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/register">S'inscrire</a></li>
			<li class="nav-item"><a class="nav-link" href="/ENI-Encheres/login">Se connecter</a></li>
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
	              <p class="mb-0">Vendeur : ${e.article.nomArticle}</p>	              
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