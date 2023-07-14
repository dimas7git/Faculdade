@extends('layouts.main')

@section('title', 'Criar Evento')

@section('content')

<div id="event-create-container" class="col-md-6 offset-md-3">
  <h1>CADASTRAR FUNCIONARIO</h1>
  <BR></BR>
  <form action="/events" method="POST" enctype="multipart/form-data">
    @csrf
    <div class="form-group">
      <label for="nome">Nome:</label>
      <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
    </div>
    <div class="form-group">
      <label for="cpf">CPF:</label>
      <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
    </div>
    <div class="form-group">
      <label for="title">Qual cargo?</label>
      <select name="cargo" id="cargo" class="form-control">
        <option value="estagio">estagio</option>
        <option value="junior">junior</option>
        <option value="pleno">pleno</option>
        <option value="senior">senior</option>
      </select>
    </div>
    <div class="form-group">
      <label for="salario">Salario:</label>
      <input type="number" class="form-control" id="salario" name="salario" placeholder="Qual salario">
    </div>
    
    <input type="submit" class="btn btn-primary" value="Criar Evento">
  </form>
</div>

@endsection