  pkg load image;
  clc;

  img = imread('cameraman128.bmp');
  img = imnoise(img, 'salt & pepper');

  figure(1),subplot(1,2,1),imshow(img);

