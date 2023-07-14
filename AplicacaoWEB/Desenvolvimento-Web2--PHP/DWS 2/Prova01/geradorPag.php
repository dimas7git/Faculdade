<?php

$titulo = filter_input(INPUT_POST, "titulo", FILTER_SANITIZE_SPECIAL_CHARS);
$corpo = filter_input(INPUT_POST, "corpo", FILTER_SANITIZE_SPECIAL_CHARS);
$cor = filter_input(INPUT_POST, "cor", FILTER_SANITIZE_SPECIAL_CHARS);
$img = filter_input(INPUT_POST, "img", FILTER_SANITIZE_SPECIAL_CHARS);
$url = filter_input(INPUT_POST, "url", FILTER_SANITIZE_SPECIAL_CHARS);




?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>Document</title>
  <style>
    body {
      margin: 40px;
    }
  </style>

</head>

<body>
  
  <h1>Formulario</h1>
  <hr>
  <form class="" action="destino.php" method="POST">
    <div class="mb-3">
      <label for="titulo" class="form-label">Titulo</label>
      <input type="text" class="form-control" name="titulo" id="titulo" aria-describedby="titulo">
    </div>
    <select name="alinhamento" id="alinhamento">
      <option value="center">centralizado</option>
      <option value="left">esquerda</option>
      <option value="right">direita</option>
    </select>
    <div class="mb-3">
      <label for="corpo" class="form-label">Corpo do texto</label>
      <input type="textarea" class="form-control" name="corpo" id="corpo">
    </div>
    <select name="repetir" id="repetir">
      <option value="0">não repetir</option>
      <option value="1">repetir 1x</option>
      <option value="2">repetir 2x</option>
      <option value="3">repetir 3x</option>
      <option value="4">repetir 4x</option>
      <option value="5">repetir 5x</option>
      <option value="6">repetir 6x</option>
      <option value="7">repetir 7x</option>
      <option value="8">repetir 8x</option>
      <option value="9">repetir 9x</option>
      <option value="10">repetir 10x</option>
    </select>
    <div class="mb-3">
      <label for="cor" class="form-label">Cor texto</label>
      <input type="color" class="form-control" name="cor" id="cor">
    </div>
    <div class="mb-3">
      <label for="img" class="form-label">URL IMAGEM</label>
      <input type="text" class="form-control" name="img" id="img">
    </div>
    <select name="mostrarimg" id="mostrarimg">
      <option value="inline">No corpo da pagina</option>
      <option value="back">No plano de fundo</option>
    </select>
    <div class="mb-3">
      <label for="url" class="form-label">Fonte</label>
      <input type="text" class="form-control" name="url" id="url">
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
    <button type="reset" class="btn btn-primary">Limpar</button>
  </form>
</body>

</html>