create or replace function f_olamundo() returns text
as
$$
begin
--Função qu emostra a frase Olá Mundo:;
return 'Olá mundo!';
end;
$$
language PLPGSQL;

--Para executar: select f_olamundo();

--

create or replace function f_substringPorNome(nomePar varchar, posicaoInicialPar integer)
returns varchar
as
$$
begin
return substring(nomePar, posicaoInicialPar);
end;
$$
language plpgsql;
select f_substringPorNome('John Doe',5);


--
--Par no final da variavel é de parâmetro
create or replace function f_SomaTresPar(Valor1 numeric,
Valor2 integer,
Valor3 Numeric)
returns numeric
as
$$
declare
Resultado numeric;
begin
resultado = Valor1+Valor2+Valor3;
return resultado;
end;
$$
language plpgsql;
select f_SomaTresPar(2.2,4,6.3);



create or replace function f_definicao (sexo char) returns text
as
$$
begin
	if (sexo = 'M' or sexo = 'm') then
		return 'Masculino';
	elseif (sexo = 'F' or sexo = 'f') then
		return 'Feminino';
	else
		return 'Indefinido';
	end if;
end;
$$
--soma de 2 parâmetros
language plpgsql;
select f_definicao('D');

CREATE OR REPLACE FUNCTION f_SomaSelect(num1Par numeric,
									    num2Par numeric)
RETURNS numeric 
AS $$
DECLARE retval numeric;
BEGIN
	SELECT num1Par + num2Par INTO retval;
	RETURN retval;
END;
$$ LANGUAGE plpgsql;

SELECT f_SomaSelect(4,5);
--Exercícios sobre funções
--Implemente um procedimento que receba 4 parâmetros. Os dois primeiros
--serão números que sofrerão uma das quatro operações básicas da matemática
--adição, subtração, multiplicação e divisão; o terceiro parâmetro será uma
--variável que armazenará o resultado da operação e por fim, o quarto parâmetro
--indicará qual será a operação realizada. Após implementar, teste o procedimento
--e veja se está funcionando corretamente.

--Resposta:
create or replace function f_claculadora (num1Par numeric, num2Par numeric, respPar numeric, operacaoPar char) returns numeric
as
$$
begin
  if operacaoPar = '+' then
    respPar = num1Par + num2Par;
  elseif operacaoPar = '-' then
    respPar = num1Par - num2Par;
  elseif operacaoPar = '*' then
    respPar = num1Par * num2Par;
  elseif operacaoPar = '/' then
    respPar = num1Par / num2Par;
  else
    respPar = 0;
  end if;

  return respPar;
end;
$$
language plpgsql;
uso: select f_claculadora(10, 5, 0, '+');
CREATE OR REPLAcE FUNCTION f_calculadora (num1Par numeric,
										  num2Par numeric,
										  respPar numeric,
										  operacaoPar char) 
RETURNS numeric
AS
$$
BEGIN
	if operacaoPar = '+' then
		respPar = num1Par + num2Par;
	elseif operacaoPar = '-' then
		respPar = num1Par - num2Par;
	elseif operacaoPar = '*' then
		respPar = num1Par * num2Par;
	elseif operacaoPar = '/' then
		respPar = num1Par / num2Par;
	else 
		respPar = 0;
	end if;
	RETURN respPar;
end;
$$
LANGUAGE PLPGSQL;
SELECT f_calculadora(10, 5, 0, '+');

--Projete uma função que informado o código do cliente por parâmetro, 
--encontre o valor total das compras desse cliente. Como retorno, 
--a função deve informar o nome do cliente concatenado com o valor da compra.
--Você deverá usar as tabelas cliente, pedido, item_pedido e produto.

CREATE OR REPLACE FUNCTION f_TotalCliente (codigo_clientePar numeric) returns text
AS
$$
DECLARE
  nome_clienteRetorno cliente.nome_cliente%type;
  Valor_TotalRetorno numeric;

BEGIN
  SELECT cliente.nome_cliente, 
         SUM(produto.valor_venda * item_pedido.quantidade) "Valor Total" 
         INTO nome_clienteRetorno, Valor_TotalRetorno 
  FROM 
         PUBLIC.cliente, PUBLIC.pedido, PUBLIC.produto, PUBLIC.item_pedido
  WHERE 
         cliente.codigo_cliente = pedido.codigo_cliente AND
         pedido.num_pedido = item_pedido.num_pedido AND
         item_pedido.codigo_produto = produto.codigo_produto AND
         cliente.codigo_cliente = codigo_clientePar
  GROUP BY cliente.nome_cliente;

  RETURN nome_clienteRetorno || ': ' || Valor_TotalRetorno;
END;
$$
LANGUAGE plpgsql;
uso: SELECT f_TotalCliente(720);

