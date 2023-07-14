<?php
session_start();
require "header.php";
?>
<h1>Formulario para contato</h1>

<form method="POST" action="destino-contato.php" >
    <div class="row">
        <div class="col-md-6">
            <label for="nome">Nome: </label>
            <input type="text" class="form-control" name="nome">
        </div>
        <div class="col">
            <label for="email">Email: </label>
            <input type="email" class="form-control" name="email">
        </div>
    </div>
    <br>
    <div class="form-group">
        <label for="msg">Mensagem: </label>
        <textarea id="msg" rows="3" cols="30"  class="form-control" name="msg"> </textarea>
    </div>
    <input type="hidden" name="data_submissao" value="<?php echo date('d-m-Y H:i:s'); ?>">

    <br>
    <button type="submit" class="btn btn-danger">Enviar</button>
    <button type="reset" class="btn btn-warning">Limpar</button>

</form>
<?php
require "footer.php";
?>