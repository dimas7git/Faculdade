pkg load image;
clc;

a = imread('Lena512.bmp');
b = imcrop(a,[100,100,200,180]);

figure(1), subplot(1,2,1), colormap(gray), imagesc(a);
figure(1), subplot(2,2,2), colormap(gray), imagesc(b);
