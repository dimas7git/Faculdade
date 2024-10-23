pkg load image;
clc;

img = imread('Lena512.bmp');

for(j = 1:512)
  for(i = 1:512)
    if(img(i,j)>220)
        img(i,j) = img(i,j)+20;
    elseif(img(i,j)<110)
        img(i,j) = img(i,j)-30;
    endif
  endfor
endfor

imshow(img);
