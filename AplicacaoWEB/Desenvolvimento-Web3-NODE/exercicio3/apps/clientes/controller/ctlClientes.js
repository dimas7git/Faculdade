const mdlClientes = require("../model/mdlClientes");


const getAllClientes = (req, res) =>
  (async () => {
    // Chama a função do modelo para buscar todos os alunos
    let registro = await mdlClientes.getAllClientes;
    // Retorna um objeto JSON com o status "ok" e os registros obtidos
    res.json({ status: "ok", "registro": registro });

  })(); 

// Função que insere um novo aluno
const insertClientes = (request, res) =>
  (async () => {
    //@ Atenção: aqui já começamos a utilizar a variável msg para retornar erros de banco de dados.
    const ClientesREG = request.body;
    // Chama a função do modelo para inserir o aluno
    let { msg, linhasAfetadas } = await mdlClientes.insertClientes(ClientesREG);
    // Retorna um objeto JSON com o status da operação e o número de linhas afetadas
    res.json({ "status": msg, "linhasAfetadas": linhasAfetadas });
  })();

  module.exports = {
    getAllClientes,
    insertClientes
};