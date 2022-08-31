<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Enchérir</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<script src="https://kit.fontawesome.com/8c94095c90.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;700&display=swap" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<main>
		<h1>Détail vente</h1>
<!-- Formulaire pour afficher les enchères -->
		<article class="vente">
			<h3>PC Gamer pour travailler</h3>
			<i class="fa-solid fa-computer"></i>
			<p><span class="type">Description :</span><input type="text"></p>
			<p><span class="type">Catégorie :</span> Informatique</p>
			<p><span class="type">Meilleure offre :</span> 210 points par Bob</p>
			<p><span class="type">Mise à prix :</span> 185 points</p>
			<p><span class="type">Fin de l'enchère :</span> 09/10/2018</p>
			<p>
				<span class="type">Retrait :</span> 10 allée des Alouettes <br> 44800 Saint Herblain
			</p>
			<p><span class="type">Vendeur :</span> jojo44</p>
		</article>
		<p>
			<span class="Proposition">Ma proposition :</span> <input type="number" min="0" value="3" step="1">
			<input type="submit" value="Enchérir">
		</p>
		<a href="pageListeEncheres.html" class="link">Back</a>
	</main>
</body>
</html>