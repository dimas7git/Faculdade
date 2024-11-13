pkg load image;
clc;

img = imread('imgAbertura.png');
img = rgb2gray(img);
SE = ones(3,3);
imgErode = imerode(img, SE);
imgAbertura = imdilate(imgErode, SE);

subplot(2,3,2), imshow(img), title ('Imagem Original');
subplot(2,3,3),imshow(imgErode), title ('Imagem Erosão');
subplot(2,3,4),imshow(imgAbertura), title ('Imagem abertura');


