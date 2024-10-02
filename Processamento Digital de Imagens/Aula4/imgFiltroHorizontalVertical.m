pkg load image;
clc;

filtro1 = [-4 -4 -4; 8 8 8; -4 -4 -4];
filtro2 = [-1 2 -1; -2 4 -2; -1 2 -1];
img = zeros(10,10);
img(3:7,3:7) =1;


img1 = conv2(filtro1,img);
img2 = uint8(img1);
img3 = conv2(filtro2,img);
img4 = uint8(img3);


figure(1),subplot(1,2,1), imshow(img1);
figure(1),subplot(1,2,2), imshow(img2);
figure(1),subplot(1,2,3), imshow(img3);
figure(1),subplot(1,2,4), imshow(img4);
