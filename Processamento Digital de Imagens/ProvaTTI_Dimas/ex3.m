pkg load image;
clc;

img = imread('imagem.bmp');

mascara = [1, 1, 1; 1, 0, 1; 1, 1, 1];
mascara = mascara/8;

img_passa_baixa = conv2(img, mascara);

imshow(img_passa_baixa, []);

