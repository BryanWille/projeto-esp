# Presp

O **Presp é um projeto feito totalmente em Java para calcular recursos de estatística descritiva**, recebendo **dados** e devolvendo **informações**. Possui uma interface gráfica feita utilizando o Java Swing.

## Como funciona?
Funciona de forma simples, podendo receber dados de forma manual (escrita pela próprio usuário) ou pela forma de arquivos .txt, que serão lidos pelo programa e terão seus valores interpretados.

O programa traz como benefício a facilitação da obtenção de dados estatísticos comumente requeridos em uma pesquisa, como Média, Mediana, Moda, Desvio Padrão, Coeficiente de Variação e etc... com dados brutos, além de proporcionar uma tabela de dados agrupados e demonstrar os valores gerados por ela, poupando o usuário de contas trabalhosas se feitas a mão.

## Como usar?
O PresP possui diversas configurações na interface de usuário inicial:

É possível que o usuário inicie o programa importando um arquivo .txt ou que o usuário escolha escrever os dados manualmente em "Inserir dados manualmente: ", desde que os dados sejam separados por um espaço.

Em "Importar arquivo de Texto: "
a opção padrão é "Dados linha por linha", que lê cada linha do .txt, pegando os dados contidos em cada uma dela. 
Caso o .txt contenha os dados em uma mesma linha, deve-se marcar a opção "Dados separados por espaço".

Em "Padrão de Dados"
Existe a opção "Dados padrão brasileiro" que assume que os dados virão no formato 1.234,56 com a vírgula para separar casas decimais.
A opção "Dados padrão americano" assume que os dados virão no formato 1,235.56 com o ponto para separar casas decimais.

Em "Configurações de arredondamento: "
A box "Arredondar dados: " ficará responsável por definir o número de casas decimais que a Média, Mediana, Moda, Desvio Padrão, Coeficiente de Variação etc serão apresentados.
E a box "Arredondar dados de classe:" ficará responsável por definir o número de casas decimais dos dados na tabela e da amplitude de classe.

## Contribuições
Ideias de melhorias são sempre aceitas!

## Licença
[MIT](https://choosealicense.com/licenses/mit/)
