<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercicio 11</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <?php
    $dados = $_POST['dados'] ?? [];
    function retornaDump($var)
    {
        echo "<pre>";
        var_dump($var);
        echo  "</pre>";
    }
    function retornaListaDados($dados)
    {
        echo "<ul>";
        sort($dados);
        for ($i = 0; $i < count($dados); $i++) {
            if ($i == 3) {
                echo "<li>...</li>";
                break;
                
            }
            echo "<li>$dados[$i]</li>";
        }
    }
    echo "</ul>";
    ?>
</head>

<body>
    <h1>Formulário</h1>
    <h2>Dados da requisição</h2>
    <?php retornaDump($dados) ?>
    <h2>Interesses selecionados (em ordem alfabética)</h2>
    <?php retornaListaDados($dados) ?>
    <a href="./">Voltar ao formulario</a>
</body>

</html>