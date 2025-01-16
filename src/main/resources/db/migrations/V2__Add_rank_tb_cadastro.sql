--V2: Migrations para adiionar a coluna de ranking na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);