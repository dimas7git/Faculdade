<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Tabuada</h1>
    <form action="tabu.php" method="get">
        <label for="numero" class="form-label">Numero</label>
        <input type="number" class="form-control-lg" name="n">
        <button type="submit" class="btn btn-primary">Calcular</button>
    </form>

    <br><br><br>
    <?php
    $n = isset($_GET['n']) ? filter_var($_GET['n'], FILTER_SANITIZE_NUMBER_INT) : false;
    $cont;
    echo "Tabuado do $n <br><br>";
    
    if($n){
    for ($cont = 0; $cont <= 10; $cont++) {
        $res = ($n * $cont);
        echo "$n x $cont = $res <br>" ;
    }
}
    ?>
</body>

</html>