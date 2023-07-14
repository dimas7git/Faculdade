<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Document</title>
    <style>
        img {
            width: 100px;
        }

        .div1 {
            border: 1px black solid;
        }
    </style>
</head>

<body>
    <h1>Exercicio 3 - Calculo de juros de um valor</h1>
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
        <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
                <form action="juros.php" method="GET">
                    <div class="card-header py-3">
                        <h4 class="my-0 fw-normal">Samsung galaxy s23</h4>
                    </div>
                    <div class="card-body">
                        <img src="s23.png" alt="">
                        <br>
                        <input type="text" id="Contato" name="preco1" value="5.399.00" style="width:150px" required readonly />
                        <span>Android 13, snapdragon 8 gen2 - 8gb/256gb, camera com nightography</span>
                        <button type="submit" class="w-100 btn btn-lg btn-outline-primary">Formas de pagamento</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
        <form action="juros.php" method="GET">
                    <div class="card-header py-3">
                    <h4 class="my-0 fw-normal">Iphone 14</h4>
                    </div>
                    <div class="card-body">
                        <img src="iphone14.jpg" alt="">
                        <br>
                        <input type="text" id="Contato" name="preco2" value="6.899.00" style="width:150px" required readonly/>
                        <span>Ios 16, chip a15 bionic -tela super retina xdr, camera dupla</span>
                        <button type="submit" class="w-100 btn btn-lg btn-outline-primary">Formas de pagamento</button>
                </form>
        </div>
    </div>
    <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm border-primary">
        <form action="juros.php" method="GET">
                    <div class="card-header py-3">
                        <h4 class="my-0 fw-normal">Xiaomi 13</h4>
                    </div>
                    <div class="card-body">
                        <img src="i666098.webp" alt="">
                        <br>
                        <input type="text" id="Contato" name="preco3" value="5.199.00" style="width:150px" required readonly/>
                        <span>Android 13 MIUI 14, snapdragon 8 gen2 - 8gb/256gb, camera com lentes leica</span>
                        <button type="submit" class="w-100 btn btn-lg btn-outline-primary">Formas de pagamento</button>
                </form>
        </div>
    </div>
    </div>

    <?php
    error_reporting(0);
    ini_set('display_errors', 0);



    $preco1 = filter_input(INPUT_GET, "preco1", FILTER_SANITIZE_SPECIAL_CHARS);
    $preco2 = filter_input(INPUT_GET, "preco2", FILTER_SANITIZE_SPECIAL_CHARS);
    $preco3 = filter_input(INPUT_GET, "preco3", FILTER_SANITIZE_SPECIAL_CHARS);

    if ($preco2 != null) {
        $preco1 = $preco2;
    } else if ($preco3 != null) {
        $preco1 = $preco3;
    }
    // $preco1 = $_GET['preco1'];
    $p3 = 0.0;
    $par1 = 0.0;
    $par2 = 0.0;
    $par3 = 0.0;
    $par4 = 0.0;
    $p5 = 0.0;
    $p12 = 0.0;
    $p18 = 0.0;
    $av = 0.0;
    $av2 = 0.0;

    $p5 = $preco1 * 1.05;
    $par1 = ($p5 / 5) * 1000;

    $p12 = $preco1 * 1.10;
    $par2 = ($p12 / 12) * 1000;

    $p18 = $preco1 * 1.15;
    $par3 = ($p18 / 18) * 1000;

    $av2 = $preco1 * 0.05;
    $av = $preco1 - $av2;

    echo "<p>O preço $preco1 </p>";
    echo "As condições de pagamento são: <br>";
    echo  "<ul>";
    echo " <li>a vista $av</li>";

    echo " <li>parcelado em 5x de $par1 totalizando $p5</li>";
    echo " <li>parcelado em 5x de $par1 totalizando $p5</li>";
    echo " <li>parcelado em 12x de $par2 totalizando $p12</li>";
    echo " <li>parcelado em 18x de $par3 totalizando $p18</li>";

    echo "</ul>";

    ?>
</body>

</html>