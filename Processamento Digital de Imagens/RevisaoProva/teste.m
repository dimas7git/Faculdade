pkg load image;
clc;

img = imread('Lena512.bmp');
img = img/32;
img = uint8(img);
img = img*32;
imshow(img);

