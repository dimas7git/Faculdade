pkg load image;
clc;

img = imread('Lena512.bmp');

img8 = img/32;
img8 = uint8(img8);
img8 = img8*32;

imshow(img8);
