<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription-Encheres</title>
</head>
<body>
	<h3>Mon profil</h3>
	<form action="ENI-Encheres/AfficherEncheresServlet" method="POST">
		Pseudo : <input type="text" name="pseudo" value="${model.creaUtilisateur.pseudo}"><br><br>
		Prenom : <input type="text" name="pseudo" value="${model.creaUtilisateur.prenom}"><br><br>
		Teléphone : <input type="text" name="pseudo" value="${model.creaUtilisateur.telephone}"><br><br>
		Code Postal : <input type="text" name="pseudo" value="${model.creaUtilisateur.codePostal}"><br><br>
		Mot de passe : <input type="text" name="pseudo" value="${model.creaUtilisateur.motDePasse}"><br><br>
		Nom : <input type="text" name="pseudo" value="${model.creaUtilisateur.nom}"><br><br>
		Email : <input type="text" name="pseudo" value="${model.creaUtilisateur.email}"><br><br>
		Rue : <input type="text" name="pseudo" value="${model.creaUtilisateur.rue}"><br><br>
		Ville : <input type="text" name="pseudo" value="${model.creaUtilisateur.ville}"><br><br>
		Confirmation : <input type="text" name="pseudo" value="${model.creaUtilisateur.confirmation}"><br><br>
		<input type="submit" name="create" value="Créer">
	</form>
		
		<form action="ENI-Encheres/AccueilServlet">
			<input type="submit" name="cancel" value="Annuler">
		</form>
</body>
</html>