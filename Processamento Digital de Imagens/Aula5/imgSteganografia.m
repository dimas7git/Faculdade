pkg load image;
clc;

img1 = imread('lenaRGB.png');
imgR = img1(:,:,1);
imgG = img1(:,:,2);
imgB = img1(:,:,3);

mensagem = imread('mensagem512.bmp');
[M N] = size(imgR);

imgMensagem = imgR;
for i = 1:M
  for j = 1:N
    imgMensagem(i,j)=bitset(imgR(i,j),1,mensagem(i,j));
  endfor
endfor

imgJunto = cat(3,imgMensagem,imgG, imgB);

imwrite(imgJunto,'marcadaAulaColorida2024.bmp');
figure(1),subplot(1,3,1), imshow(img1), title('Imagem original');
figure(1),subplot(1,3,2), imshow(mensagem), title('mensagem');
figure(1),subplot(1,3,3), imshow(imgJunto), title('Imagem com a mensagem');

