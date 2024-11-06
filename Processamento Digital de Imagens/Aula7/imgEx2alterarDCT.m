clear all;
clc;
pkg load image;
pkg load signal;

img = imread('Lena512.bmp');

imgDct = dct2(img);
imgDctUITN = uint8(imgDct);
imgnovo = imgDct;

for a = 510:512
  for b = 510:512
    imgnovo(a,b) = imgDct(a,b) * 2.5;
  endfor
endfor

imgnovoUINT = uint8(imgnovo);
imgnovo1 = idct2(imgnovo);
imgnovo1 = uint8(imgnovo1);

figure(1), subplot(2,2,1), imshow(img), title('Original');
figure(1), subplot(2,2,2), imshow(imgDctUITN),title('DCT');
figure(1), subplot(2,2,3), imshow(imgnovoUINT),title('DCT Alterado');
figure(1), subplot(2,2,4), imshow(imgnovo1), title('Imagem final alterado');

imwrite(imgnovo1, 'imagemEx2.bmp');
