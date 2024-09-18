pkg load image;
clc;

imgMaior = imread('Lena512.bmp');
imgMenor = imread('if30.bmp');
imgMenor1 = rgb2gray(imgMenor);

[M,N] = size(imgMenor);
imgNova = imgMaior;

for i=1:M
  for j = 1:N+512
    imgNova(i,j) = (imgMenor(i,j));
  endfor
endfor

figure(1), subplot(1,3,1),imshow(imgMaior);
figure(1), subplot(1,3,2),imshow(imgMenor);
figure(1), subplot(1,3,3),imshow(imgNova);
imwrite(imgNova, 'lenaif.bmp');
