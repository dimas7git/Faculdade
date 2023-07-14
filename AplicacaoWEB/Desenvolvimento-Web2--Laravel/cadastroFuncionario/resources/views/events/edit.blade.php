@extends('layouts.main')

@section('title', 'Editando: ' . $event->title)

@section('content')

<div id="event-create-container" class="col-md-6 offset-md-3">
  <h1>Editando: {{ $event->title }}</h1>
  <form action="/events/update/{{ $event->id }}" method="POST" enctype="multipart/form-data">
    @csrf
    @method('PUT')
    <div class="form-group">
      <label for="title">Nome:</label>
      <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" value="{{ $event->nome }}">
    </div>
    <div class="form-group">
      <label for="title">CPF:</label>
      <input type="text" class="form-control" id="cpf" name="cpf" value="{{ $event->cpf }}">
    </div>
    <div class="form-group">
      <label for="title">Salario:</label>
      <input type="number" class="form-control" id="salario" name="salario" placeholder="Local do evento" value="{{ $event->salario }}">
    </div>
    <div class="form-group">
      <label for="title">O evento é privado?</label>
      <select name="cargo" id="cargo" class="form-control">
      <option value="estagio">estagio</option>
        <option value="junior">junior</option>
        <option value="pleno">pleno</option>
        <option value="senior">senior</option>
      </select>
    </div>
    <input type="submit" class="btn btn-primary" value="Editar Evento">
  </form>
</div>

@endsection