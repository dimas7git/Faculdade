pkg load image;
clc;

img1 = imread('lenaRGB.jpg');
imgR = img1(:,:,1);
imgG = img1(:,:,2);
imgB = img1(:,:,3);

mensagem = imread('MSG1.bmp');
mensagem2 = imread('MSG2.bmp');
mensagem3 = imread('MSG3.bmp');

[M, N] = size(imgR);

imgMensagemR = imgR;
imgMensagemG = imgG;
imgMensagemB = imgB;

for i = 1:M
    for j = 1:N
        imgMensagemR(i,j) = bitset(imgR(i,j), 1, mensagem(i,j));
        imgMensagemG(i,j) = bitset(imgG(i,j), 1, mensagem2(i,j));
        imgMensagemB(i,j) = bitset(imgB(i,j), 1, mensagem3(i,j));
    end
end

imgJunto = cat(3, imgMensagemR, imgMensagemG, imgMensagemB);

figure(1); subplot(2, 3, 1); imshow(img1); title('Imagem Original');

subplot(2, 3, 2); imshow(imgMensagemR); title('banda r com mensagem escondida');

subplot(2, 3, 3);imshow(imgMensagemG);title('banda g com mensagem escondida');

subplot(2, 3, 4);imshow(imgMensagemB);title('banda b com mensagem escondida');

subplot(2, 3, 5);imshow(imgJunto);title('Imagem com 3 Mensagens');



