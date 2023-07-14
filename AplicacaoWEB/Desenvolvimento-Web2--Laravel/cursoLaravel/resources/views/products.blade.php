@extends('layouts.main')
@section ('title', 'Dimas')
@section ('content')   


<h1>tela de produto</h1>
@if($busca != '')
<p>O usuario esta boscando por : {{$busca}}</p>
@endif