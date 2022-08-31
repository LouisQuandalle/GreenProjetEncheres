<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Détail ma vente</title>
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

        <article class="vente">
            <h3 class="title">Rocket stove pour riz et pâtes</h3>
            <img src="rocket stove.jpg" alt="Rocket Stove" class="image">
            <p><span class="type" <%= offre %>>Meilleure offre :</span> 210 points par jojo44</p> <!-- Remplacement par des variables pour afficher les offres -->
            <p><span class="type" <%= prix %>>Mise à prix :</span> 175 points</p>
            <p><span class="type" <%= fin %>>Fin de l'enchère :</span> 09/10/2018</p>
            <p><span class="type" <%= retrait %>>Retrait :</span> 5 rue des Pinsons <br> 44000 Nantes</p>
            <p><span class="type" <%= vendeur %>>Vendeur :</span> NineJea</p>
        </article>
        <p>
            <input type="submit" value="Annuler la vente" class="button" <%= submit %>>
            <br>
            <br>
            <a href="pageListeEncheres.html">
                <i class="fa-solid fa-rotate-left"></i>
            </a>
        </p>
    </main>
</body>
</html>