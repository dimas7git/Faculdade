pkg load image;
clc;

imgIF = imread('if.jpg');
imgIFG = rgb2gray(imgIF);

figure(1), imshow(imgIF), title('Imagem usada de fundo');
figure(2), imshow(imgIFG), title('Logotipo');
