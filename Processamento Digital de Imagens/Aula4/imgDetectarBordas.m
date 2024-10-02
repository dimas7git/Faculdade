pkg load image;
clc;

s = [1 2 1; 0 0 0; -1 -2 -1];
img = zeros(10,10);
img(3:7,3:7) =1;
b = conv2(s,img);

figure(1),subplot(1,2,1), imshow(img);
figure(1),subplot(1,2,2), imshow(b);
