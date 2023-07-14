<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <h2>Formulário PHP</h2>
    <form method="POST" action="cont.php">
        <label for="inicio">Início:</label>
        <input type="number" id="inicio" name="inicio"><br><br>

        <label for="final">Final:</label>
        <input type="number" id="final" name="final"><br><br>

        <label for="incremento">Incremento:</label>
        <input type="number" id="incremento" name="incremento"><br><br>
        <input type="submit" value="Enviar">

    </form>

    <?php
    $inicio = isset($_POST['inicio']) ? filter_var($_POST['inicio'], FILTER_SANITIZE_NUMBER_INT) : false;
    $final = isset($_POST['final']) ? filter_var($_POST['final'], FILTER_SANITIZE_NUMBER_INT) : false;
    $incremento = isset($_POST['incremento']) ? filter_var($_POST['incremento'], FILTER_SANITIZE_NUMBER_INT) : false;
    if ($inicio) {
        if ($inicio > $final) {
            for ($i = $inicio; $i >= $final; $i -= $incremento) {
                echo $i . "<br>";
            }
        }
        if ($inicio < $final) {
            for ($i = $inicio; $i <= $final; $i += $incremento) {
                echo $i . "<br>";
            }
        }
    }
    ?>
</body>

</html>