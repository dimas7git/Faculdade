pkg load image;
clc;

img = imread('Lena512.bmp');

for(j = 1:512)
  for(i = 1:512)
    if(img(i,j)<=60)
        img(i,j) = 30;
    elseif(img(i,j)<=140)
        img(i,j) = 100;
    elseif(img(i,j)<=200)
        img(i,j) = 170;
    elseif(img(i,j)<=255)
        img(i,j) = 250;
    endif
  endfor
endfor

imshow(img);
