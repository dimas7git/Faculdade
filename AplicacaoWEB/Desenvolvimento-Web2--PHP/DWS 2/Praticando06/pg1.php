<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
                .reprovado{
                    color: red;
                }
                .recuperacao{
                    color: yellow;
                }
                .aprovado{
                    color: green;
                }
        </style>
</head>

<body>
        <h1>Calculadora de média</h1>
        <hr>
        <?php

            $n1 = $_POST['n1'];
            $n2 = $_POST['n2'];
            $n3 = $_POST['n3'];

            $total = ($n1+$n2+$n3)/3;
           
            ?>
             <br>

            <?php 
                if ($total < 4){
                    echo "O aluno com as notas $n1, $n2, $n3 com a média $total está <strong><u class='reprovado'>REPROVADO!</u></strong></div>";
                }
                elseif ($total < 6){
                    echo "O aluno com as notas $n1, $n2, $n3 com a média $total está em <strong><u class='recuperacao'>RECUPERAÇÂO!</u></strong></div>";
                }
                elseif ($total >= 6){
                    echo "O aluno com as notas $n1, $n2, $n3 com a média $total está <strong><u  class='aprovado'>APROVADO!</u></strong></div>";
                }
            ?>

            <br>
            <br>
            <a href="formu.php">Voltar</a>

        </div>   
        
</html>