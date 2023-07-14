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
    <h1>Formulario</h1>
    <div class="container">
        <form action="calc.php" method="post">
            <div class="mb-3 row-3">
                <label for="notaA" class="form-label">Nota Avaliação</label>
                <input type="text" class="form-control-lg" name="notaA">

            </div>
            <div class="mb-3 row-3">
                <label for="notaTrab" class="form-label">Nota Trabalho</label>
                <input type="text" class="form-control-lg" name="notaTrab">

            </div>
            <div class="mb-3 row-3">
                <label for="notaPra" class="form-label">Nota Praticando</label>
                <input type="text" class="form-control-lg" name="notaPra">

            </div>
            <button type="submit" class="btn btn-primary">Calcular média</button>
            <button type="reset" class="btn btn-secondary">Limpar</button>
        </form>
    </div>

    <?php
    error_reporting(0);
    ini_set('display_errors', 0);

    $notaA = $_POST['notaA'];
    $notaTrab = $_POST['notaTrab'];
    $notaPra = $_POST['notaPra'];
    $media = 0.0;

    if (isset($notaA)) {
        if (($notaA >= $notaTrab) && ($notaA >= $notaPra) && ($notaTrab >= $notaPra)) {
            echo "Nota Avaliação $notaA <br>";
            echo "Nota Trabalho $notaTrab <br>";
            echo "Nota Praticando $notaPra<br>";
        } else if (($notaTrab >= $notaA) && ($notaTrab >= $notaPra) && ($notaA >= $notaPra)) {
            echo "Nota Trabalho $notaTrab <br>";
            echo "Nota Avaliação $notaA <br>";
            echo "Nota Praticando $notaPra<br>";
        } else if (($notaPra >= $notaTrab) && ($notaPra >= $notaA) && ($notaTrab >= $notaA)) {
            echo "Nota Praticando $notaPra<br>";
            echo "Nota Trabalho $notaTrab <br>";
            echo "Nota Avaliação $notaA <br>";
        } else  if (($notaA >= $notaTrab) && ($notaA >= $notaPra) && ($notaPra >= $notaTrab)) {
            echo "Nota Avaliação $notaA <br>";
            echo "Nota Praticando $notaPra<br>";
            echo "Nota Trabalho $notaTrab <br>";
        }else  if (($notaTrab >= $notaA) && ($notaTrab >= $notaPra) && ($notaPra >= $notaA)) {
            echo "Nota Trabalho $notaTrab <br>";
            echo "Nota Praticando $notaPra<br>";
            echo "Nota Avaliação $notaA <br>";
        }else  if (($notaPra >= $notaTrab) && ($notaPra >= $notaA) && ($notaA >= $notaTrab)) {
            echo "Nota Praticando $notaPra<br>";
            echo "Nota Avaliação $notaA <br>";
            echo "Nota Trabalho $notaTrab <br>";
    
        }
        
    $media = (($notaA * 5) + ($notaTrab * 2) + ($notaPra * 3)) / 10;
        echo "Média $media";
    }
   


    

 

    ?>
</body>

</html>