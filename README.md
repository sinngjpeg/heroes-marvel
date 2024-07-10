# Marvel Heroes App

## Resumo do Projeto

Aplicativo Android que permite aos usuários explorar informações sobre super-heróis da Marvel, consumindo dados da API pública da Marvel.

## Funcionalidades Principais

- **Lista de Heróis**: Exibir uma lista de heróis da Marvel com imagens e nomes.
- **Detalhes do Herói**: Ao clicar em um herói na lista, exibir detalhes como descrição e lista de quadrinhos onde o herói aparece.
- **Busca de Heróis**: Implementar uma funcionalidade de busca para que os usuários possam encontrar heróis específicos pelo nome.
- **Integração com API da Marvel**: Consumir endpoints da API pública da Marvel para obter informações sobre heróis, quadrinhos, séries, etc. 
- **UI/UX Atraente**: Design responsivo e agradável, seguindo as diretrizes de Material Design. Experiência de usuário intuitiva e fluida na navegação entre telas e na interação com os dados.
- **Testes Unitários**: Implementar testes unitários para as partes críticas do aplicativo, utilizando frameworks como JUnit e Mockito para testes de lógica e mocks.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Kotlin
- **Arquitetura**: MVVM (Model-View-ViewModel) para separação clara de responsabilidades e facilitar testes.
- **Bibliotecas e Frameworks**:
  - Retrofit para comunicação com a API.
  - Coroutines para operações assíncronas.
  - Glide para carregamento e exibição de imagens.
  - Room para armazenamento local de dados.
  - Mockito e JUnit para testes unitários.
  - RecyclerView e RecyclerViewAdapter para exibição de listas.

## Executando o Projeto

## Configuração da API da Marvel

Para utilizar a API da Marvel nesse projeto Android, você precisa configurar suas chaves API no arquivo `local.properties`. Este arquivo é utilizado para armazenar informações confidenciais que não devem ser armazenadas no código-fonte, como as chaves da API.

#### 1. Obtenha suas chaves da API Marvel

- Crie uma conta no [Marvel Developer Portal](https://developer.marvel.com/) caso ainda não tenha uma.
- Após se registrar, acesse a seção "Minha API Keys" e gere um novo par de chaves API (pública e privada).
- Guarde suas chaves API em um local seguro, pois elas são confidenciais e não devem ser compartilhadas com ninguém.

#### 2. Crie o arquivo `local.properties`

- Se o arquivo `local.properties` não existir em seu diretório raiz do projeto, crie-o manualmente.
- Certifique-se de que o arquivo não seja incluído no controle de versão do seu projeto, pois ele contém informações confidenciais.

#### 3. Adicione as chaves da API ao `local.properties`

- Abra o arquivo `local.properties`.
- Adicione as seguintes linhas, substituindo `{PUBLIC_KEY}` pela sua chave pública da API Marvel e `{PRIVATE_KEY}` pela sua chave privada da API Marvel:

```plaintext
PUBLIC_KEY="{PUBLIC_KEY}"
PRIVATE_KEY="{PRIVATE_KEY}"
```
## Links Uteis
