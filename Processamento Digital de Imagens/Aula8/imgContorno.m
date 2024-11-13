pkg load image;
clc;

img = imread('if30.bmp');

SE = ones(3,3);
imgErode = imerode(img, SE);
imgContorno = img - imgErode;

subplot(2,3,2), imshow(img), title ('Imagem Original');
subplot(2,3,3),imshow(imgErode), title ('Imagem Erosão');
subplot(2,3,4),imshow(imgContorno), title ('Imagem contorno');


