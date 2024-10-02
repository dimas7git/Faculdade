pkg load image;
clc;

img = imread('cameraman128.bmp');
img = imnoise(img, 'salt & pepper');
[M,N] = size(img);
c = img;
c = double(c);

for i=2:M-1
  for j=2:N-1
    c(i,j) = ((1*(c(i-1,j-1))) + (1*(c(i-1,j))) + (1*(c(i-1,j+1)))
    + (1*(c(i,j-1))) + (1*(c(i,j))) + (1*(c(i,j+1))) + (1*(c(i+1,j-1)))
    + (1*(c(i+1,j))) + (1*(c(i+1,j+1))))/9;
  endfor
endfor


c = uint8(c);
figure(1),subplot(1,2,1),imshow(img);
figure(1),subplot(1,2,2),imshow(c);

