<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Connexion</title>
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
        <form action="" method="POST" class="connexion">
            <p> 
                <label class="label">Identifiant :</label>
                <input type="text" placeholder="Entrer le nom d'utilisateur" name="username" required class="infos" >
            </p>
            <p>
                <label class="label">Mot de passe :</label>
                <input type="password" placeholder="Entrer le mot de passe" name="password" required class="infos" >
            </p>
            <p>
                <input type="submit" id='submit' value='Connexion'class="button" >
                <input type="checkbox" id="rememberme" name="rememberme" value="1" />
                <label for="rememberme">Se souvenir de moi</label><br><br>
                <a href="" class="link">Mot de passe oublié</a><br>
            </p>
        </form><br>
        <a href="pageCreerCompte.html" class="link">Créer un compte</a>
    </main>

</body>
</html>