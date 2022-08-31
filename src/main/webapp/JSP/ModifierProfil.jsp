<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Modifier mon compte</title>
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
        <h1>Mon profil</h1>
        <form name="créeruncompte" action="" method="post">
            <p>
                <label for="pseudo" class="type">Pseudo :</label>
                <input type="text" name ="pseudo" <%= pseudo %>/>
            </p>
            <p>
                <label for="nom" class="type">Nom :</label>
                <input type="text" name ="nom" <%= nom %>/>
            </p>
            <p>
                <label for="prenom" class="type">Prénom :</label>
                <input type="text" name ="prenom" <%= prenom %>/>
           </p>
           <p> 
                <label for="email" class="type">Email :</label>
                <input type="email" name ="email"<%= mail %> />
            </p>    
            <p>
                <label for="telephone" class="type">Téléphone :</label>
                <input type="tel" name ="telephone"<%= tel %>/>
            </p>
            <p>
                <label for="rue" class="type">Rue :</label>
                <input type="text" name ="rue"<%= rue %> />
            </p>    
            <p>
            <label for="codepostal" class="type">Code postal :</label>
            <input type="number" name ="codepostal" min="0" max="98000"<%= code postal %>/>
            </p> 
            <p>
                <label for="ville" class="type">Ville :</label>
                <input type="text" name ="ville" <%= ville %>/>
            </p>
            <p>
                <label for="motdepasse" class="type">Mot de passe :</label>
                <input type="password" name ="motdepasse"<%= password %> />
            </p>
            <p>
                <label for="confirmation" class="type">Confirmation :</label>
                <input type="password" name ="confirmation" <%= password %>/>
            </p>
            <p>
                <span class="credit">Crédit :</span> 640
            </p>
            <p>
                <input type="submit" value="Enregistrer" class="button"/>
                <br>
                <br>
                <a href="" class="link">
                    <i class="fa-solid fa-trash"></i>
                    <span>Supprimer mon compte</span>
                </a>
                <br>
                <br>
                <a href="pagesListeEncheresDeconnecte.html" class="link"> 
                    <i class="fa-solid fa-ban"></i>
                    <span>Annuler</span>  
                </a> 
            </p>
           
        </form>

    </main>

</body>
</html>