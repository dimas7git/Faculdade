pkg load image;
clc;

img1 = imread('lenaRGB.png');
imgR = img1(:,:,1);
imgG = img1(:,:,2);
imgB = img1(:,:,3);

mensagem = imread('mensagem1.bmp');
mensagem2 = imread('mensagem2.bmp');
mensagem3 = imread('mensagem3.bmp');

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

imwrite(imgJunto, 'imagemComMensagem.bmp');

figure(1); subplot(2, 3, 1); imshow(img1); title('Imagem Original');

subplot(2, 3, 2); imshow(mensagem); title('Mensagem 1');

subplot(2, 3, 3);imshow(mensagem2);title('Mensagem 2');

subplot(2, 3, 4);imshow(mensagem3);title('Mensagem 3');

subplot(2, 3, 5);imshow(imgJunto);title('Imagem com Mensagens');


