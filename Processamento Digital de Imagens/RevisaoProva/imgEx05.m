pkg load image;
clc;

imgA = imread('ImagemA.bmp');
imgB = imread('ImagemB.bmp');
imgC = imread('ImagemC.bmp');

[Xa, Ya] = size(imgA);
[Xb, Yb] = size(imgB);
[Xc, Yc] = size(imgC);

imgnova = imgA;

for i = 1:Xb
  for j = 1:Yb
    imgnova(Xa-i, j) = imgB(i,j);
  endfor
endfor

for i = 1:Xc
  for j = 1:Yc
    imgnova(Xa-i, Ya-j) = imgC(i,j);
  endfor
endfor

imshow(imgnova);
