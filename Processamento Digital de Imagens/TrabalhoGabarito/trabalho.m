#INTEGRANTES - DIMAS FERREIRA - MATHEUS SASS - EDUARDO ALBERT
pkg load image;
clc;

img = imread('Group 3.png');
img_gray = rgb2gray(img);
gabarito = [1, 2, 3, 3, 2, 3, 1, 2];

x_start = 27;
y_start = 42;
x_step = 25;
question_step = 15;

acertos = 0;

for i = 1:length(gabarito)
    y = y_start + (i - 1) * question_step;

    resposta = 0;
    min_mean_value = 255;

    for j = 1:4
        x = x_start + (j - 1) * x_step;

        square_region = img_gray(y:y+20, x:x+20);
        mean_value = mean(square_region(:));

        fprintf('Questão %d, Alternativa %d, Média de pixels: %f\n', i, j, mean_value);

        if mean_value < min_mean_value
            resposta = j;
            min_mean_value = mean_value;
        end
    end

    if resposta == gabarito(i)
        acertos += 1;
    end
end

fprintf('Número de acertos: %d\n', acertos);

