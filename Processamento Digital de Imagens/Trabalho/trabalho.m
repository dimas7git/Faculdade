clear all;
clc;

% Carregar a imagem em escala de cinza e converter para binário
imagem = imread('respostas.png');
imagem_gray = rgb2gray(imagem);
imagem_bin = imagem_gray < 128;  % Imagem binária (1 para preto, 0 para branco)

% Gabarito das respostas corretas
gabarito = [
    1 0 0 0; % Questão 1: Alternativa A correta
    0 0 1 0; % Questão 2: Alternativa C correta
    0 0 1 0; % Questão 3: Alternativa C correta
    0 0 0 1; % Questão 4: Alternativa D correta
    0 0 1 0; % Questão 5: Alternativa C correta
    0 1 0 0; % Questão 6: Alternativa B correta
    1 0 0 0; % Questão 7: Alternativa A correta
    0 0 1 0; % Questão 8: Alternativa C correta
];

% Parâmetros de configuração
num_questoes = size(gabarito, 1);
num_alternativas = size(gabarito, 2);
respostas = zeros(num_questoes, num_alternativas);

% Parâmetros de posição dos quadrados das alternativas
linha_inicio = 40;                 % Linha onde começa a primeira questão
coluna_inicio = 27;                % Coluna onde começa a primeira alternativa
distancia_entre_alternativas = 15; % Distância entre os quadrados das alternativas
tamanho_quadrado = 10;             % Tamanho do quadrado (10x10 pixels)
altura_questao = 115;              % Espaçamento vertical entre as questões

% Processamento das respostas do aluno
for questao = 1:num_questoes
    for alternativa = 1:num_alternativas
        % Calcular a posição do centro do quadrado da alternativa
        y = linha_inicio + (questao - 1) * altura_questao;
        x = coluna_inicio + (alternativa - 1) * distancia_entre_alternativas;
        y_centro = y + round(tamanho_quadrado / 2);
        x_centro = x + round(tamanho_quadrado / 2);

        % Verificar se o pixel central do quadrado está marcado (preto)
        if y_centro <= size(imagem_bin, 1) && x_centro <= size(imagem_bin, 2)
            if imagem_bin(y_centro, x_centro) == 1
                respostas(questao, alternativa) = 1;
            end
        else
            fprintf('Coordenadas fora dos limites: Questão %d, Alternativa %d -> (%d, %d)\n', questao, alternativa, x_centro, y_centro);
        end
    end
end

% Comparar respostas do aluno com o gabarito
acertos = sum(all(gabarito == respostas, 2));
fprintf('O aluno acertou %d questões.\n', acertos);

