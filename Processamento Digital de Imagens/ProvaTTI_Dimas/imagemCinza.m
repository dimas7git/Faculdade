pkg load image;
clc;

a = ones(300,300);
a = uint8(a);
a = a * 120;
a = imnoise(a, 'salt and pepper');

imwrite(a, 'imagem.bmp');
