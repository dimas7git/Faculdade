pkg load image;
clc;

imga = ones(120,120);
imga = uint8(imga);
imga = imga *0;

imgb = ones(60,60);
imgb = uint8(imgb);
imgb = imgb *120;

imgc = ones(20,20);
imgc = uint8(imgc);
imgc = imgc *220;

imgnovo = imga;

for a = 1:60
  for b = 1:60
    imgnovo(120 - a,b) = imgb(a,b);
  endfor
endfor
for c = 1:20
  for d = 1:20
    imgnovo(c, d+120) = imgc(c,d);
  endfor
endfor


figure(1); subplot(1,4,1); imshow(imga);
figure(1); subplot(1,4,2); imshow(imgb);
figure(1); subplot(1,4,3); imshow(imgc);
figure(1); subplot(1,4,4); imshow(imgnovo);
