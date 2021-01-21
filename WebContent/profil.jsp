<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Profil-Encheres</title>
</head>
<body>

<jsp:include page="logo.jsp"></jsp:include>

	Pseudo : ${model.utilisateur.pseudo} <br><br>
	Nom :  ${model.utilisateur.nom} <br><br>
	Prenom :  ${model.utilisateur.prenom} <br><br>
	Email : ${model.utilisateur.email} <br><br>
	Télephone :  ${model.utilisateur.telephone} <br><br>
	Rue :  ${model.utilisateur.rue} <br><br>
	Code Postal :  ${model.utilisateur.codePostal} <br><br>
	Ville :  ${model.utilisateur.ville} <br><br>
  
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>
