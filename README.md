# Marvel Heroes App

## Resumo do Projeto

Aplicativo Android que permite aos usuários explorar informações sobre super-heróis da Marvel, consumindo dados da API pública da Marvel.

## Funcionalidades Principais

- **Lista de Heróis**: Exibir uma lista de heróis da Marvel com imagens e nomes.
- **Detalhes do Herói**: Ao clicar em um herói na lista, exibir detalhes como descrição e lista de quadrinhos onde o herói aparece.
- **Busca de Heróis**: Implementar uma funcionalidade de busca para que os usuários possam encontrar heróis específicos pelo nome.
- **Integração com API da Marvel**: Consumir endpoints da API pública da Marvel para obter informações sobre heróis, quadrinhos, séries, etc. 
- **Testes Unitários**: Implementar testes unitários para as partes críticas do aplicativo, utilizando frameworks como JUnit e Mockito para testes de lógica e mocks.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Kotlin
- **Arquitetura**: Clean Architecture e MVVM (Model-View-ViewModel) para separação clara de responsabilidades e facilitar testes.
- **Bibliotecas e Frameworks**:
  - Retrofit para comunicação com a API.
  - Coroutines para operações assíncronas.
  - Glide para carregamento e exibição de imagens.
  - Mockito e JUnit para testes unitários.
  - Pagging3, RecyclerView e RecyclerViewAdapter para exibição de listas.

## Executando o Projeto

### Configuração da API da Marvel

Para utilizar a API da Marvel nesse projeto Android, você precisa configurar suas chaves API no arquivo `local.properties`. Este arquivo é utilizado para armazenar informações confidenciais que não devem ser armazenadas no código-fonte, como as chaves da API.

##### 1. Obtenha suas chaves da API Marvel

- Crie uma conta no [Marvel Developer Portal](https://developer.marvel.com/) caso ainda não tenha uma.
- Após se registrar, acesse a seção "Minha API Keys" e gere um novo par de chaves API (pública e privada).
- Guarde suas chaves API em um local seguro, pois elas são confidenciais e não devem ser compartilhadas com ninguém.

##### 2. Crie o arquivo `local.properties`

- Se o arquivo `local.properties` não existir em seu diretório raiz do projeto, crie-o manualmente.
- Certifique-se de que o arquivo não seja incluído no controle de versão do seu projeto, pois ele contém informações confidenciais.

##### 3. Adicione as chaves da API ao `local.properties`

- Abra o arquivo `local.properties`.
- Adicione as seguintes linhas, substituindo `{PUBLIC_KEY}` pela sua chave pública da API Marvel e `{PRIVATE_KEY}` pela sua chave privada da API Marvel:

```plaintext
PUBLIC_KEY="{PUBLIC_KEY}"
PRIVATE_KEY="{PRIVATE_KEY}"
```
## Configuração do JDK 11

O projeto precisa ser configurado com o JDK 11. 

Configurar o JDK 11 no Android Studio

Para baixar e configurar o JDK 11 diretamente no Android Studio, siga os passos abaixo:

#### 1: Abrir Configurações do Android Studio

1. Abra o Android Studio.
2. No menu principal, clique em `File` -> `Project Structure`.

#### 2: Configurar o JDK

1. Na janela `Project Structure`, selecione `SDK Location` no painel esquerdo.
2. No campo `JDK location`, clique em `Download JDK`.

#### 3: Baixar o JDK 11

1. Na janela que se abrir, selecione `JDK version` e escolha a versão `11` na lista.
2. Clique em `Download` para iniciar o download e a instalação do JDK 11.

#### 4: Confirmar a Instalação

1. Após o download e a instalação, o campo `JDK location` será preenchido automaticamente com o caminho do JDK 11 recém-instalado.
2. Clique em `Apply` e depois em `OK` para salvar as configurações.

#### 5: Verificar a Configuração

1. Para garantir que o Android Studio está usando o JDK correto, vá até `File` -> `Settings` (ou `Android Studio` -> `Preferences` no macOS) -> `Build, Execution, Deployment` -> `Build Tools` -> `Gradle`.
2. Certifique-se de que a opção `Gradle JDK` está definida para o JDK 11 que você acabou de instalar.

Seguindo esses passos, você terá o JDK 11 configurado corretamente no Android Studio, pronto para rodar seu projeto.

## Links Uteis

- [https://medium.com/nerd-for-tech/nested-recyclerview-in-android-e5afb2b9771a]
- [https://developer.android.com/build/dependencies]
- [https://square.github.io/retrofit/]
- [https://munstein.medium.com/primeiros-passos-com-detekt-10416fc90638]
- [https://guides.codepath.com/android/Storing-Secret-Keys-in-Android]
- [https://www.toptal.com/developers/gitignore/api/android,androidstudio]
- [https://developer.android.com/training/dependency-injection]
- [https://developer.android.com/guide/navigation/principles]
- [https://medium.com/@cardosof.gui/clean-architecture-e-mvvm-no-desenvolvimento-android-6f542d0f2e99]
- [https://developer.android.com/guide/fragments/fragmentmanager]
