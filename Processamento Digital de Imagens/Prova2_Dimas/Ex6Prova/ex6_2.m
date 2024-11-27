pkg load image;
clc;

imgJunto = imread('imagemComMensagem.bmp');
imgR = imgJunto(:,:,1);
imgG = imgJunto(:,:,2);
imgB = imgJunto(:,:,3);

[M, N] = size(imgR);

mensagemExtraida = zeros(M, N);
mensagem2Extraida = zeros(M, N);
mensagem3Extraida = zeros(M, N);

for i = 1:M
    for j = 1:N
        mensagemExtraida(i,j) = bitget(imgR(i,j), 1);
        mensagem2Extraida(i,j) = bitget(imgG(i,j), 1);
        mensagem3Extraida(i,j) = bitget(imgB(i,j), 1);
    end
end

mensagemExtraida = uint8(mensagemExtraida * 255);
mensagem2Extraida = uint8(mensagem2Extraida * 255);
mensagem3Extraida = uint8(mensagem3Extraida * 255);

figure(1);subplot(2, 2, 1);imshow(imgJunto);title('Imagem com 3 mensagens escondidas');

subplot(2, 2, 2);imshow(mensagemExtraida);title('Mensagem Extraída 1');

subplot(2, 2, 3);imshow(mensagem2Extraida);title('Mensagem Extraída 2');

subplot(2, 2, 4);imshow(mensagem3Extraida);title('Mensagem Extraída 3');



