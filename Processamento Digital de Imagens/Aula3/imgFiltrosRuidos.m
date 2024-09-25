pkg load image;
clc;

a = imread('lena512.bmp');
b = imnoise(a, 'gaussian');
c = imnoise(a, 'gaussian', 0, 0.03);
d = imnoise(a, 'salt & pepper');
e = imnoise(a, 'salt & pepper', 0.05);

figure(1), subplot(3,3,2), imshow(a), title('Imagem Original');
figure(1), subplot(3,3,4), imshow(b), title('Ruido Gaussiano');
figure(1), subplot(3,3,6), imshow(c), title('Ruido Gaussino - média 0 - variancia 0.003');
figure(1), subplot(3,3,7), imshow(d), title('Ruido Sal e Pimenta');
figure(1), subplot(3,3,9), imshow(e), title('Ruido Sal e Pimenta - intensidade 0.05');

