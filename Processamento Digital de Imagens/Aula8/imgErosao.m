pkg load image;
clc;

img = imread('lena512.mbp');
imgBW = im2bw(img);

SE = ones(3,3);
imgErode = imerode(imgBW, SE);

subplot(2,3,2);imshow(img), title ('Imagem Original');
subplot(2,3,4);imshow(imgBW), title ('Imagem PB');
subplot(2,3,6);imshow(imgErode), title ('Imagem Erosão');

