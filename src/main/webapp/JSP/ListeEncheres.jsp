<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Accueil</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<script src="https://kit.fontawesome.com/8c94095c90.js" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;700&display=swap" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>

<body>
	<script type="text/javascript">
		function CheckCase() {
			if (document.getElementById("condition").checked) {
				document.getElementById("envoyer").disabled = "";
				document.getElementById("envoyer2").disabled = "";
				document.getElementById("envoyer3").disabled = "";
				document.getElementById("envoyer4").disabled = "disabled";
				document.getElementById("envoyer5").disabled = "disabled";
				document.getElementById("envoyer6").disabled = "disabled";
			} else {
				document.getElementById("envoyer").disabled = "disabled";
				document.getElementById("envoyer2").disabled = "disabled";
				document.getElementById("envoyer3").disabled = "disabled";
				document.getElementById("envoyer4").disabled = "";
				document.getElementById("envoyer5").disabled = "";
				document.getElementById("envoyer6").disabled = "";
			}
		}
	</script>

	<!-- Si les boutons de types radio ne sont pas cochés, il sera impossible de sélectionner les checkbox -->

	<header>
		<nav class="navbar">
			<ul class="navbar-menu">
				<li class="navbar-item">
					<a href="pageListeEncheres.html" class="navbar-link">
						<i class="fa-solid fa-house"></i> 
						<span class="navbar-title">ENI-ENCHÈRES</span>
					</a>
				</li>
				<li class="navbar-item">
					<a href="pageVendreUnArticle.html" class="navbar-link">
						<i class="fa-solid fa-brush"></i>
						<span class="navbar-title">Vendre un article</span>
					</a> 
				</li>
				<li class="navbar-item">
					<a href="pageProfil.html" class="navbar-link">
						<i class="fa-solid fa-user" ></i>
						<span class="navbar-title">Mon Profil</span>
					</a> 
				</li>
					<li class="navbar-item">
					<a href="pagesListeEncheresDeconnecte.html" class="navbar-link">
						<i class="fa-solid fa-right-from-bracket"></i>
						<span class="navbar-title">Déconnexion</span>
					</a>
				</li>
			</ul>
		</nav>
	</header>
	<main>

		<h3>FILTRES :</h3>
		<form name="filtres" action="" method="post">
			<fieldset class="fieldset">
				<input type="radio" onclick="CheckCase()" name="choix"
					id="condition">Achats<br>
				<fieldset class="fieldset">
					<input type="checkbox" disabled="disabled" name="mode" id="envoyer">enchères ouvertes <br> 
					<br> 
					<input type="checkbox" disabled="disabled" name="mode" id="envoyer2">mes enchères en cours <br>
					<br> 
					<input type="checkbox" disabled="disabled" name="mode" id="envoyer3">mes enchères remportées
				</fieldset>
				<br>
				<input type="radio" onclick="CheckCase()" name="choix"
					id="condition2">Mes ventes<br>
				<fieldset class="fieldset">
					<input type="checkbox" disabled="disabled" name="mode" id="envoyer4">mes ventes en cours <br> 
					<br> 
					<input type="checkbox" disabled="disabled" name="mode" id="envoyer5">ventes	non débutées <br> 
					<br> 
					<input type="checkbox" disabled="disabled"	name="mode" id="envoyer6">ventes terminées
				</fieldset>
			</fieldset>
			<br>
			<label for="categorie"  class="categories">Catégories: </label> <select name="categorie" size="1">
				<option value="empty" selected="selected">-</option>
				<option value="informatique">Informatique</option>
				<option value="ameublement">Ameublement</option>
				<option value="vetement">Vêtements</option>
				<option value="sport">Sport et Loisirs</option>
			</select> 
			<input type="text" name="nom" id="nom" placeholder="Le nom de l'article contient" size="50" class="BarreRecherche"/> 
			<input type="submit" name="submit" value="Recherche" class="rechercher" />
		</form>

		<article class="article">
			<img src="">
			<h4>Titre de l'article</h4>
			<p>Prix : xxx pts Classement : xx</p>
			<p>Fin de l'enchère : DD/MM/AAAA</p>
			<p>Retrait : RUE CODE POSTAL VILLE</p>
			<p>Vendeur : NOM VENDEUR</p>
		</article>

		<article class="article">
			<img src="">
			<h4>Titre de l'article</h4>
			<p>Prix : xxx pts Classement : xx</p>
			<p>Fin de l'enchère : DD/MM/AAAA</p>
			<p>Retrait : RUE CODE POSTAL VILLE</p>
			<p>Vendeur : NOM VENDEUR</p>
		</article>

	</main>

</body>
</html>