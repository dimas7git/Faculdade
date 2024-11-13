pkg load image;
clc;

img = imread('imgFechamento.png');
img = rgb2gray(img);
SE = ones(3,3);
imgDilate = imdilate(img, SE);
imgFechamento = imerode(imgDilate, SE);

subplot(2,3,2), imshow(img), title ('Imagem Original');
subplot(2,3,3),imshow(imgDilate), title ('Imagem dilatada');
subplot(2,3,4),imshow(imgFechamento), title ('Imagem fechada');


