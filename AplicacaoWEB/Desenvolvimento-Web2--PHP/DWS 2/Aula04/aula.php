<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Document</title>
    <style>
      body{
            margin: 40px;
        }
    </style>
    
</head>
<body>
    <h1>Formulario</h1>
    <hr>
    <form class="" action="desino.php" method="POST">
        <div class="mb-3">
          <label for="titulo" class="form-label">Titulo</label>
          <input type="text" class="form-control" name="titulo" id="titulo" aria-describedby="titulo">
        </div>
        <div class="mb-3">
          <label for="corpo" class="form-label">Corpo do texto</label>
          <input type="textarea" class="form-control" name="corpo" id="corpo">
        </div>
        <div class="mb-3">
          <label for="cor" class="form-label">Cor texto</label>
          <input type="color" class="form-control" name="cor" id="cor">
        </div>
        <div class="mb-3">
          <label for="img" class="form-label">URL IMAGEM</label>
          <input type="text" class="form-control" name="img" id="img">
        </div>
        <div class="mb-3">
          <label for="url" class="form-label">URL</label>
          <input type="text" class="form-control" name="url" id="url">
        </div>
        <div class="mb-3">
          <label for="corf" class="form-label">Cor plano de fundo</label>
          <input type="color" class="form-control" name="corf" id="corf">
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
        <button type="reset" class="btn btn-primary">Limpar</button>
      </form>
</body>
</html>