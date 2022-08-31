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
    <%@ include file="navbar.jsp" %>

    <main>
        <h1>Liste des enchères</h1>
        
        <h3 class="filtres">FILTRES :</h3>
        <form name ="article" action ="" method="get">
            <label for="categorie" class="categories">Catégories: </label>
            <select name="categorie" size="1">
                <option value="empty" selected="selected">-</option>
                <option value ="informatique">Informatique</option>
                <option value ="ameublement">Ameublement</option>
                <option value ="vetement">Vêtements</option>
                <option value ="sport">Sport et Loisirs</option>
            </select>
            <input type="text" name="nom" id="nom" placeholder="Le nom de l'article contient" size = "50" class="BarreRecherche"/>
            <input type="submit" name="submit" value="Recherche" />
        </form>
        
        <article class="article">
            <i class="fa-solid fa-bag-shopping" id="shop"></i>
            <h4>Titre de l'article</h4>
            <p>Prix : xxx pts Classement : xx</p>
            <p>Fin de l'enchère : DD/MM/AAAA</p>
            <p>Retrait : RUE CODE POSTAL VILLE</p>
            <p>Vendeur : NOM VENDEUR</p>
        </article>

        <article class="article">
            <i class="fa-solid fa-bag-shopping" id="shop"></i>
            <h4>Titre de l'article</h4>
            <p>Prix : xxx pts Classement : xx</p>
            <p>Fin de l'enchère : DD/MM/AAAA</p>
            <p>Retrait : RUE CODE POSTAL VILLE</p>
            <p>Vendeur : NOM VENDEUR</p>
        </article>

    </main>

</body>
</html>