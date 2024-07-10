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
Abra o Android Studio.
No menu principal, clique em File -> Project Structure.
Na janela que abrir, selecione SDK Location no painel esquerdo.
No campo JDK location, clique em ... para abrir o seletor de diretórios.
Navegue até o diretório onde você instalou o JDK 11. No Windows, o caminho típico pode ser C:\Program Files\Java\jdk-11, enquanto no macOS e Linux pode ser algo como /Library/Java/JavaVirtualMachines/jdk-11/Contents/Home ou /usr/lib/jvm/java-11-openjdk-amd64/.
Selecione a pasta correspondente ao JDK 11 e clique em OK.
Clique em Apply e depois em OK para salvar as configurações.
Passo 3: Verificar a Configuração
Ainda no Android Studio, vá até File -> Project Structure novamente.
Na seção SDK Location, confirme que o caminho do JDK location está apontando para o diretório do JDK 11.
Para garantir que o Android Studio está usando o JDK correto, você pode também verificar a versão do JDK em File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle. Certifique-se de que a opção Gradle JDK está definida para o JDK 11.
Seguindo esses passos, você terá o JDK 11 configurado corretamente para rodar seu projeto no Android Studio.

## Links Uteis
