# KonPOO-Transportes
Software para administração dos processos necessários ao funcionamento da empresa fictícia KonPOO.
Link do github: https://github.com/eduardomartignoni/KonPOO-Transportes


Ao inicilizar o programa ele carrega os dados salvos nos arquivos.csv, em seguida utilizamos a classe App para executar um menu no qual o usuário escolhe dentre as opções:

Cadastrar novo destino - é necessário informar: cidade (String), nome (String), latitude (int), longitude (int); o código do destino é preenchido automaticamente e é mostrado na hora de informar um destino quando for cadastar uma carga.

Cadastrar novo caminhão -  é necessário informar: nome (String), autonomia (double), codigo (int), velocidade (double), capacidadePeso(int); o código do caminhão deve ser único e o custoPorKm é calculado automaticamente com base no preço da gasolina.

Cadastrar novo cliente - é necessário informar: código (int), nome (String), telefone (String); o código do Cliente deve ser único.

Cadastrar novo tipo de carga - é necessário informar:  descrição (String), numero(int); o número do tipo de carga deve ser único, em seguida é necessário informar se a carga é Percível ou Durável:
Perecível possui origem (String) e validade (int);
Durável: possui materialPrincipal (String) e setor (String).

Cadastrar nova carga - é necessário informar: código (int), peso (int), tempoMaximo (int), valorDeclarado (double); o código da carga deve ser único.

Consultar todas as cargas: Imprime todas as cargas cadastradas e todos dados das cargas.

Alterar a situação de uma carga, - o usuário pode alterar o status de uma carga a partir do código dela, os status possíveis são: Locada, Cancelada ou Finalizada. Caso a carga já tenha sido finalizada não será possível alterar o status.

Fretar cargas: o sistema irá automaticamente designar um caminhão para cada carga, com base na Queue de cargas pendentes. Caso haja um caminhão com capacidade de realizar o frete, mas esse mesmo já se encontre locado, a carga voltará para o final da fila. Caso não haja nenhum caminhão com capacidade de realizar o frete, a carga será cancelada. No final é impresso na tela qual a situação de cada carga.

Sair - finaliza o programa salvando os dados inseridos pelo usuário nos arquivos.csv


Algumas das dificuldades que encontramos foram:

Trocar de painel na interface.
Instanciar objetos a partit do csv e lidar com os eventuais erros.
O atributo caminhaoDesignado que é um Objeto do tipo caminhão da classe Carga estava causando bugs em diversos métodos, foi necessário verificar em todos métodos no qual o caminhaoDesignado era impresso para verificar se ele poderia ser nulo naquele momento e criar uma condição para isso/

NOMES: ARTUR KALIL, EDUARDO MARTIGNONI, GEFERSON RODRIGUES ROCHA
