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
   <%@ include file="navbar.jsp" %>

    <main>
        <h1>Mon profil</h1>
        <form name="créeruncompte" action="${pageContext.request.contextPath}/ServletCreationCompte" method="post">
            <p>
                <label for="pseudo" class="type">Pseudo :</label>
                <input type="text" name ="pseudo" />
            </p>
            <p>
                <label for="nom" class="type">Nom :</label>
                <input type="text" name ="nom" />
            </p>
            <p>
                <label for="prenom" class="type">Prénom :</label>
                <input type="text" name ="prenom" />
           </p>
           <p> 
                <label for="email" class="type">Email :</label>
                <input type="email" name ="email" />
            </p>    
            <p>
                <label for="telephone" class="type">Téléphone :</label>
                <input type="tel" name ="telephone"/>
            </p>
            <p>
                <label for="rue" class="type">Rue :</label>
                <input type="text" name ="rue" />
            </p>    
            <p>
            <label for="codepostal" class="type">Code postal :</label>
            <input type="number" name ="codepostal" min="0" max="98000"/>
            </p> 
            <p>
                <label for="ville" class="type">Ville :</label>
                <input type="text" name ="ville" />
            </p>
            <p>
                <label for="motdepasse" class="type">Mot de passe :</label>
                <input type="password" name ="motdepasse" />
            </p>
            <p>
                <label for="confirmation" class="type">Confirmation :</label>
                <input type="password" name ="confirmation" />
            </p>
            <p>
                <span class="credit">Crédit :</span> 640 <!-- Variable pour les crédits? -->
            </p>
            <p>
                <input type="submit" value="Enregistrer" class="button"/>
        </form>

    </main>

</body>
</html>