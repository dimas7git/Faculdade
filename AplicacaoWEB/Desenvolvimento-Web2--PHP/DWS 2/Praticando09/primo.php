<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .result {
            background-color: #f5f5f5;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 20px;
            font-size: 18px;
            font-weight: bold;
        }
        .red{
            color: red;
        }
        .green{
            color: green;
        }
    </style>
</head>

<body>
    <?php
    if (isset($_GET['valor'])) {
        $valor = $_GET['valor'];
        echo "<br><br>";
        if ($valor % 2 == 0) {
            echo "<span class='result';'>O número é <bold class='red'>par. </bold></span><br><br><br>";
        } else {
            echo "<span class='result';'>O número é <bold class='green'>impar. </bold></span><br><br><br>";
        }
        $primo = true;
        for ($i = 2; $i <= sqrt($valor); $i++) {
            if ($valor % $i == 0) {
                $primo = false;
                break;
            }
        }
        
        if ($primo && $valor > 1) {
            echo "<span class='result';'>O número é <bold class='green'>primo. </bold> .</span>";
        } else {
            echo "<span class='result''>O número não é <bold class='red'>não primo. </bold> </span>";
        }
        echo "<br><br>";
    }
    ?>
    <form method="get" action="primo.php">
        <div class="l">
            <a href="?valor=1">Numero 1</a><br>
            <a href="?valor=2">Numero 2</a><br>
            <a href="?valor=3">Numero 3</a><br>
            <a href="?valor=4">Numero 5</a><br>
            <a href="?valor=5">Numero 20</a><br>
            <a href="?valor=6">Numero 32</a><br>
            <a href="?valor=7">Numero 37</a><br>
        </div>
    </form>

</body>

</html>