const mdlClientes = require("../model/mdlClientes");


const getAllClientes = (req, res) =>
  (async () => {
    // Chama a função do modelo para buscar todos os alunos
    let registro = await mdlClientes.getAllClientes();
    // Retorna um objeto JSON com o status "ok" e os registros obtidos
    res.json({ status: "ok", "registro": registro });

  })(); 

// Função que insere um novo aluno
const insertClientes = (request, res) =>
  (async () => {
    //@ Atenção: aqui já começamos a utilizar a variável msg para retornar erros de banco de dados.
    const ClientesREG = request.body;
    // Chama a função do modelo para inserir o aluno
    console.log("[insertClientesCTL",ClientesREG) 
    let { msg, linhasAfetadas } = await mdlClientes.insertClientes(ClientesREG);
    // Retorna um objeto JSON com o status da operação e o número de linhas afetadas
    res.json({ "status": msg, "linhasAfetadas": linhasAfetadas });
  })();

  const getClienteByID = (req, res) =>
  (async () => {
    // Obtém o ID do aluno a partir do corpo da requisição
    const clienteid = parseInt(req.body.clienteid);
    // Chama a função do modelo para buscar o aluno pelo ID
    let registro = await mdlClientes.getClienteByID(clienteid);
    // Retorna um objeto JSON com o status "ok" e o registro obtido
    res.json({ status: "ok", registro: registro });
  })();


  const updateClientes = (request, res) =>
  (async () => {
    const clienteREG = request.body;
    // Chama a função do modelo para atualizar o aluno
    let  { msg, linhasAfetadas } = await mdlClientes.updateClientes(clienteREG);
    // Retorna um objeto JSON com o status da operação e o número de linhas afetadas
    res.json({ "status": msg, "linhasAfetadas": linhasAfetadas });
  })();

  const DeleteClientes = (request, res) =>
  (async () => {
    const clienteREG = request.body;
    // Chama a função do modelo para excluir o aluno
    let { msg, linhasAfetadas } = await mdlClientes.DeleteClientes(clienteREG);
    // Retorna um objeto JSON com o status da operação e o número de linhas afetadas
    res.json({ "status": msg, "linhasAfetadas": linhasAfetadas });
  })();

  module.exports = {
    getAllClientes,
    insertClientes,
    getClienteByID,
    updateClientes,
    DeleteClientes
};