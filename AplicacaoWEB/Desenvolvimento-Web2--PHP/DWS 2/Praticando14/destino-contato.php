<?php
session_start();
require "header.php";
?>
<?php

$nome = $_POST['nome'] ?? [];
$email = $_POST['email'] ?? [];
$msg = $_POST['msg'] ?? [];

echo "Nome informado: $nome <br>";
echo "Email: $email <br>";
echo "msg: $msg <br>";

$data_submissao = $_POST['data_submissao'];
echo 'Data: ' . date('d/m/Y H:i:s', strtotime($data_submissao));

$documento = 'documento';

if (!file_exists($documento)) {
    if (mkdir($documento, 0777)) {
    }
}

$caminho_arquivo = 'C:/xampp/htdocs/dimas/Praticando12/documento';
$nome_arquivo = 'contato' . uniqid() . '.txt';
$conteudo_arquivo = "Contato via site:\n\nData: $data_submissao\nnome: $nome\nemail: $email\nmensagem: $msg";
file_put_contents($caminho_arquivo . '/' . $nome_arquivo, $conteudo_arquivo);


?>
<?php
require "footer.php";
?>