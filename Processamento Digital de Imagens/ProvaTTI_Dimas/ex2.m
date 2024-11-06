pkg load image;
clc;

img = imread('imagem.bmp');

mascara = [-1, -1, -1; 2, 2, 2; -1, -1, -1];

img_bordas = conv2(img, mascara);

imshow(img_bordas)

