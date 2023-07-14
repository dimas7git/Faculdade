<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
  <h1>Formulario</h1>
  <div class="container">
  <form action="pg1.php" method="post">
    <div class="mb-3 row-3">
      <label for="exampleInputEmail1" class="form-label">Numero 1</label>
      <input type="number" class="form-control-lg" name="n1">
     
    </div>
    <div class="mb-3 row-3">
      <label for="exampleInputEmail1" class="form-label">Numero 2</label>
      <input type="number" class="form-control-lg" name="n2">
     
    </div>
    <div class="mb-3 row-3">
      <label for="exampleInputEmail1" class="form-label">Numero 3</label>
      <input type="number" class="form-control-lg" name="n3">
     
    </div>
    <button type="submit" class="btn btn-primary">Calcular</button>
    <button type="reset" class="btn btn-secondary">Limpar</button>
  </form>
  </div>
</body>
</html>