<?php 
session_start();

date_default_timezone_set('America/Sao_Paulo');
?>
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
    
    
    echo "<h1>$titulo</h1>";
    


    $alinhamento = $_POST['alinhamento'];
    $repetir = $_POST['repetir'];
    $mostrarimg = $_POST['mostrarimg'];
    $back = '';
    if ($repetir == 0) {
        echo "<p>$corpo</p>";
    } else {
        for ($i = 1; $repetir >= $i; $i++) {
            echo "<p>$corpo </p>";
        }
    }

    if($mostrarimg=='inline'){
        echo "<img src='$img' class='tama'/>";
    }else{
        $back = $img;
    }   
    //echo $back;


    echo "<br><br>";
    echo  date('d-m-Y H:i:s');
    ?>

    <br>
    <a href="<?php echo $url ?>"><?php echo $url ?></a>
    <p>
        <a href="geradorPag.php">Voltar para o formulario</a>
    </p>

    <style>
        body {
            background-image: url(<?php echo $back ?>);
            color: <?php echo $cor; ?>;
            text-align: <?php echo $alinhamento ?>;
        }

        .tama {
            width: 500px;
        }
    </style>
</body>

</html>