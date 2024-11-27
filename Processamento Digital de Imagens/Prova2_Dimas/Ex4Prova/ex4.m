pkg load image;
clc;

imgA = imread('imgA.bmp');
imgB = imread('imgB.bmp');
imgC = imread('imgC.bmp');

imgnovo = imgA;

for a = 1:40
  for b = 1:40
    imgnovo(100 - a,b) = imgB(a,b);
  endfor
endfor
for c = 1:20
  for d = 1:20
    imgnovo(c, d+80) = imgC(c,d);
  endfor
endfor


figure(1); subplot(1,4,1); imshow(imgA);
figure(1); subplot(1,4,2); imshow(imgB);
figure(1); subplot(1,4,3); imshow(imgC);
figure(1); subplot(1,4,4); imshow(imgnovo);

