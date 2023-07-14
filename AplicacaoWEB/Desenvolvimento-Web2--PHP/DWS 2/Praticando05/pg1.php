<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Document</title>
    <?php
    $animal = $_GET['animal'] ?? '';

    function retornaTextoanimal($animal)
    {
        switch ($animal) {
            case 'Gato':
                echo "<p> Os gatos são misteriosos e independentes, mas também são carinhosos e leais companheiros.
                .</p>";
                break;
            case 'Cachorro':
                echo "<p>    Os cachorros são animais leais e amorosos, que nos ensinam a importância de viver cada momento com alegria e entusiasmo.
            </p>";
                break;
            case 'Lagartixa':
                echo "<p>    As lagartixas são pequenos répteis noturnos, que com sua habilidade de escalar paredes e teto, são uma lembrança constante de que a natureza sempre nos surpreende com suas criaturas fascinantes.
            </p>";
                break;
            case 'Hamster':
                echo "<p>    Os hamsters podem ser pequenos em tamanho, mas são grandes em personalidade, trazendo alegria e diversão para qualquer lar.
            </p>";
                break;
        }
    }
    ?>
    <style>
        img {
            width: 400px;
            height: 200px;
        }
    </style>
</head>
</head>

<body>
    <h1>Praticando - ANIMAIS</h1>
    <?php
    if ($animal == '') {
        echo "<div class='d-flex'>
            <a  href='?animal=Gato'>
                <img src='gato.jpg' '/>
            </a>
            <a  href='?animal=Cachorro'>
                <img src='cachorro.jpg' '/>
            </a>
            <a  href='?animal=Lagartixa'>
                <img src='lagartixa.jpg' '/>
            </a>
            <a  href='?animal=Hamster'>
                <img src='hamster.jpg' '/>
            </a>
            </div>";
    } else {
        echo "<div style='display:flex; flex-direction: column;'>
            <p>Você clicou em um <b>$animal</b>.</p>
            <img style='width: 30%' src='./$animal.jpg' />";
        retornaTextoanimal($animal);
        echo "<a href='pg1.php'>Voltar</a>
            </div>";
    }
    ?>
</body>

</html>