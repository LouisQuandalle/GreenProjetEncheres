<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Vendre un Article</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src="https://kit.fontawesome.com/8c94095c90.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;700&display=swap" rel="stylesheet">
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
    <header>
        <nav class="navbar">
			<ul class="navbar-menu">
				<li class="navbar-item">
					<a href="pageListeEncheres.html" class="navbar-link">
						<i class="fa-solid fa-house"></i>
						<span class="navbar-title">ENI-ENCHÈRES</span>
					</a>
				</li>
			</ul>
		</nav>
    </header>
    <main>
        <h1>Nouvelle vente</h1>
        <article class="vente">
            <form name="formulairevente" action="">
            <label for="article" class="ref">Article</label>
            <input type="text" name="article" id="article" placeholder="nom de l'article ?" size="30" maxlength="50" autofocus="autofocus" /><br>
            <br>
            <label for="categorie" class="categories">Catégories: </label>
            <select name="categorie" size="1">
                <option value="empty" selected="selected">-</option>
                <option value ="informatique">Informatique</option>
                <option value ="ameublement">Ameublement</option>
                <option value ="vetement">Vêtements</option>
                <option value ="sport">Sport et Loisirs</option>
            </select><br>
            <br>
            <label for="description" class="description">Description : </label><br>
            <textarea id="description" name="description" rows="5" cols="33"></textarea><br>
            <br>
            <label for="image" class="type">Photo de l'article</label>
            <input type="file" id="photo" name="photo" accept="image/png, image/jpeg" multiple class="image"/><br>
            <br>
            <label for="prixinitial" class="type">Prix initial:</label>
            <input type="number" name="prixinitial" min="1" step="1" /><br>
            <br>
            <label for="debutenchere" class="type" <%= dateDebut %>>Début de l'enchère</label>
            <input type="date"><br>
            <br>
            <label for="finenchere" class="type" <%= dateFin %>>Fin de l'enchère</label>
            <input type="date"><br>
            <br>
            <label for="retrait" class="type" <%= retrait %>>Retrait :</label>
            <input type="text"><br>
            <br>
            <p>
                <input type="submit" value="Enregistrer" class="button" <%= enregistrer %>>
                <a href="pageListeEncheres.html" class="link">Annuler</a>
            </p>
            </form>
        </article>
     </main>
</body>
</html>