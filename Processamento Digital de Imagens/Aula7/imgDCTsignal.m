clear all;
clc;
pkg load image;
pkg load signal;

img = imread('Lena512.bmp');

imgFreq = dct2(img);

imgVolta = idct2(imgFreq);
imgVolta = uint8(imgVolta);

figure(1), subplot(1,3,1), imshow(img);
figure(1), subplot(1,3,2), colormap(gray), image(imgFreq);
figure(1), subplot(1,3,3), imshow(imgVolta);
