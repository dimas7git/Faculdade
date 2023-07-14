<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Document</title>
</head>

<body>
    <h1>Praticando 4 - Gerador de tabela</h1>
    <?php 
    $linhas = isset($_POST['linhas']) ? filter_var($_POST['linhas'], FILTER_SANITIZE_NUMBER_INT) : false;
    $colunas = isset($_POST['colunas']) ? filter_var($_POST['colunas'], FILTER_SANITIZE_NUMBER_INT) : false;
    $estilo = isset($_POST['estilo']) ? filter_var($_POST['estilo'], FILTER_SANITIZE_SPECIAL_CHARS) : false;

    ?>
    <form action="gerador.php" method="POST">
        <label for="linhas">linhas:</label>
        <input type="number" id="linhas" name="linhas"><br>

        <label for="colunas">colunas:</label>
        <input type="number" id="colunas" name="colunas"><br>

        <label for="estilo">estilo: </label>
        <select name="estilo" id="estilo"> $_POST['estilo']
            <option value="table-primary">table-primary</option>
            <option value="table-success">table-sucess</option>
            <option value="table-danger">table-danger</option>
            <option value="table-warning">table-warning</option>
            <option value="table-dark">table-dark</option>
        </select>

        <input type="submit" value="Enviar">

    </form>
    <table class="table <?php echo $estilo ?>">
        <?php

        for ($i = 1; $i <= $linhas; $i++) {
            echo "<tr>";
            for ($j = 1; $j <= $colunas; $j++) {
                echo "<td>----- </td>";
            }
            echo "</tr>";
        }
        ?>
    </table>
</body>

</html>