# Sistema de Seleção de Rotas de Entrega com Árvores Hierarquizadas

Este é um projeto desenvolvido como parte da disciplina de Algoritmos e Estruturas de Dados 2 (AED2), com o objetivo de criar um Sistema de Seleção de Rotas de Entrega usando árvores hierarquizadas. O projeto é conduzido pelos estudantes Guilherme Tavares, Giovana, e Giordana.

## Funcionalidades Principais

- **Árvores Hierarquizadas**: Utilizamos estruturas de árvores hierarquizadas para representar as rotas de entrega, permitindo uma organização eficiente dos pontos de entrega.

- **Interface de Usuário Intuitiva**: Desenvolvemos uma interface de usuário amigável que permite aos usuários inserir dados sobre os pontos de entrega e visualizar as rotas selecionadas de forma clara.

- **Implementação em Java**: Todo o projeto é implementado na linguagem de programação Java, tornando-o altamente portátil e escalável.

- **Controle de Versão com Git**: Utilizamos o controle de versão Git para colaborar de forma eficiente no desenvolvimento do projeto, permitindo o acompanhamento de alterações e a colaboração entre os membros da equipe.

## Especificações da criação do projeto

- **Sistemas Operacionais**: Windows 11 e, principalmente, MacOS
- **IDE**: IntelliJ IDEA da JetBrains

## Como Funciona o Projeto

### Árvore
- A Raiz é a Empresa que faz as entregas. <br> <br>
- Cada nível da árvore representa a hierarquia de cada tipo de via urbana: <br>
   Nível 1 -> Marginais <br>
   Nível 2 -> Avenidas <br>
   Nível 3 -> Ruas <br> <br>

- Todas as vias são identificadas por números únicos de 3 dígitos sendo: <br>
   1º dígito: representa a marginal na qual esta rua é filha <br>
   2º dígito: representa a avenida na qual esta rua é filha <br>
   3º dígito: representa a posição da rua no vetor de filhos da avenida <br> <br>
- Não existe Marginal 0, nem Avenida 0, nem Rua 0 <br> <br>
- Todas as ruas estão conectadas diretamente a uma avenida, que por sua vez se conectam diretamente com as marginais.
Não há ruas ligadas diretamente a marginais nesse projeto. <br> <br>
- **Exemplo 1**: a rua de número 456, significa que é a rua 6, da avenida 5, da marginal 4.
- **Exemplo 2**: a rua 101 não pode ser colocada, uma vez que seria uma rua conectada diretamente a uma marginal
- **Exemplo 3**: a via 100 é uma marginal
- **Exemplo 4**: a via 220 é uma avenida

- No  início do programa, já é criado um mapa (inserido vias na árvore) como padrão.

### Interface e Manipulação da Árvore

1. **Painel**: onde aparece as mensagens do terminal de sucesso ou falha na ação
2. **Limpar**: abaixo do painel, há um botão para limpar as mensagens que estão no painel
3. **Mostrar**: acima do painel, existem botões para mostrar as Ruas, Avenidas e Marginais já existentes na árvore
4. **Inserir**: Campo de escrita para "Nome" da via e campos para escolher o número único 
da via de acordo com as regras especificadas acima
5. **Interditar**: campo de escrita para o "Nome" da via que deseja interditar; ao interditar uma rua,
não é possível passar por ela mais
6. **Rota**: campo de escrita para o "Nome" da via em que se deseja chegar.
7. **Percursos**: selecione o percurso e clique no botão "Percurso" para percorrer a árvore de forma escolhida
8. **Ajuda**: canto superior esquerdo, botão de ajuda para mostrar essas intruções dentro do programa

## Como Executar o Projeto

1. Clone este repositório em sua máquina local:

   ```bash
   git clone https://github.com/tavaresgmg/SistemaDeEntregas.git
2. Abra o projeto em sua IDE Java preferida.
3. Execute o programa a partir da classe principal (Main).
4. Utilize a interface de usuário para inserir dados sobre os pontos de entrega e realizar a seleção de rotas.
   
## Contribuindo

Nós valorizamos a contribuição de outros estudantes e desenvolvedores interessados em aprimorar este projeto. Se você deseja contribuir, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch para suas alterações:
bash
Copy code
git checkout -b feature/nova-funcionalidade
3. Faça suas alterações e comite-as:
bash
Copy code
git commit -m "Adiciona nova funcionalidade"
4. Envie suas alterações para o seu fork:
bash
Copy code
git push origin feature/nova-funcionalidade
5. Abra um pull request neste repositório. Descreva suas alterações e aguarde a revisão.
   
## Autores

Guilherme Tavares,
Giovana,
Giordana.

## Licença

Este projeto é licenciado sob a Licença MIT.
