<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $titulo = filter_input(INPUT_POST, "titulo", FILTER_SANITIZE_SPECIAL_CHARS);
    $corpo = filter_input(INPUT_POST, "corpo", FILTER_SANITIZE_SPECIAL_CHARS);
    $cor = filter_input(INPUT_POST, "cor", FILTER_SANITIZE_SPECIAL_CHARS);
    $img = filter_input(INPUT_POST, "img", FILTER_SANITIZE_SPECIAL_CHARS);
    $url = filter_input(INPUT_POST, "url", FILTER_SANITIZE_SPECIAL_CHARS);
    $corf = filter_input(INPUT_POST, "corf", FILTER_SANITIZE_SPECIAL_CHARS);
    echo "<h1>$titulo</h1>";
    echo "<p>$corpo</p>";
    echo "<img src='$img' class='tama'/>";
    ?>

    <br>
    <a href="<?php echo $url ?>"><?php echo $url ?></a>
    <p>
        <a href="aula.php">Voltar para o formulario</a>
    </p>

    <style>
        body {
            background-color: <?php echo $corf; ?>;
            color: <?php echo $cor; ?>;
        }

        .tama {
            width: 500px;
        }
    </style>
</body>

</html>