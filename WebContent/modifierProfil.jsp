<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier profil-Encheres</title>
</head>
<body>
	<h3>Modifier profil</h3>
	<form action="ENI-Encheres/AfficherEncheresServlet" method="POST">
		Pseudo : <input type="text" name="pseudo" value="${model.modifUtilisateur.pseudo}"><br><br>
		Prenom : <input type="text" name="pseudo" value="${model.modifUtilisateur.prenom}"><br><br>
		Teléphone : <input type="text" name="pseudo" value="${model.modifUtilisateur.telephone}"><br><br>
		Code Postal : <input type="text" name="pseudo" value="${model.modifUtilisateur.codePostal}"><br><br>
		Mot de passe actuel: <input type="text" name="pseudo"><br><br>
		Nouveeau mot de passe: <input type="text" name="pseudo"><br><br>		

		Nom : <input type="text" name="pseudo" value="${model.modifUtilisateur.nom}"><br><br>
		Email : <input type="text" name="pseudo" value="${model.modifUtilisateur.email}"><br><br>
		Rue : <input type="text" name="pseudo" value="${model.modifUtilisateur.rue}"><br><br>
		Ville : <input type="text" name="pseudo" value="${model.modifUtilisateur.ville}"><br><br>
		Confirmation : <input type="text" name="pseudo" value="${model.modifUtilisateur.confirmation}"><br><br>
		Credit : ${model.modifUtilisateur.credit}<br><br>
		<input type="submit" name="save" value="Enregistrer">
	</form>
	
	<form action="AccueilServlet">
			<input type="submit" name="delete" value="Supprimer mon compte">
		</form>
</body>
</html>