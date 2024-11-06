clear all;
clc;
pkg load image;
pkg load signal;

img = imread('Lena512.bmp');

imgDct = dct2(img);

imgnovo = imgDct;

for a = 1:2
  for b = 1:2
    imgnovo(a,b) = imgDct(a,b) * 2.5;
  endfor
endfor

imgnovo1 = idct2(imgnovo);
imgnovo1 = uint8(imgnovo1);

figure(1), subplot(2,2,1), imshow(img), title('Original');
figure(1), subplot(2,2,2), imshow(imgDct),title('DCT');
figure(1), subplot(2,2,3), imshow(imgnovo),title('DCT Alterado');
figure(1), subplot(2,2,4), imshow(imgnovo1), title('Imagem final alterado');

imwrite(imgnovo1, 'imagemEx1.bmp');
