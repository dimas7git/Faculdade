<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Destino</title>
</head>

<body>
    <h1>Destino GET</h1>
    <hr>
    <?php
    $nome = filter_input(INPUT_GET, "nome", FILTER_SANITIZE_SPECIAL_CHARS);
    $email = filter_input(INPUT_GET, "email", FILTER_SANITIZE_EMAIL);
    $cor = filter_input(INPUT_GET, "cor", FILTER_SANITIZE_SPECIAL_CHARS);
    echo "<p>Nome infomrado: $nome<br>Email: $email</p>";

    ?>

    <p>
    
        <a href="destino.php?nome=Dimas&email=dimas@gmail.com<?php echo '&cor=' . $cor?>">ENVIAR DADOS [NOME= Dimas | EMAIL = dimas@gmail.com]</a>
        <br><br>
        <a href="destino.php?nome=Mateus&email=Mateus@gmail.com<?php echo '&cor=' . $cor?>" >ENVIAR DADOS [NOME= Mateus | EMAIL = Mateus@gmail.com]</a>
        <br><br>
        <a href="destino.php"> limpar tudo</a>
    </p>
    <br><br><br><br>
    <p>

        <a href="destino.php?cor=blue<?php echo '&nome=' . $nome . '&email=' . $email ?>" ><img src="timao.png" class="img"></a>
        <a href="destino.php?cor=green<?php echo '&nome=' . $nome . '&email=' . $email ?>" > <img src="palmeiras.png" class="img"> </a>
        <a href="destino.php?cor=red<?php echo '&nome=' . $nome . '&email=' . $email ?>" > <img src="flamengo.png" class="img"> </a>

    </p>

    <style>
        body {
            background-color: <?php echo $cor; ?>;
        }
        .img{
            width: 400px;
        }
    </style>
</body>

</html>