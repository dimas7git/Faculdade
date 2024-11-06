pkg load image;
clc;

img = imread('Lena512.bmp');
imgOriginal = imread('Lena512.bmp');

for (i = 1:512)
  for (j = 1:512)
     if(img(i,j) <= 30)
        img(i,j) = 0;
     elseif (img(i,j) <= 90)
        img(i,j) = 85;
     elseif (img(i,j) <= 180)
        img(i,j) = 170;
     else
        img(i,j) = 255;
     endif
  endfor
endfor

imshow(img);
imshow(imgOriginal);
