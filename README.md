# 🦸‍♂️ Marvel Heroes App

Bem-vindo ao **Marvel Heroes App**! 🎉 Este é um aplicativo Android que permite aos usuários explorar informações sobre seus super-heróis favoritos da Marvel, consumindo dados diretamente da API pública da Marvel. 🌟

## 📝 **Resumo do Projeto**

O **Marvel Heroes App** foi desenvolvido para oferecer uma experiência interativa e informativa sobre o universo Marvel. 💥

### 🚀 **Funcionalidades Principais**

- 🦸‍♀️ **Lista de Heróis:** Exibe uma lista de heróis da Marvel com imagens e nomes.
- 📄 **Detalhes do Herói:** Ao clicar em um herói, exibe detalhes como descrição e lista de quadrinhos onde ele aparece.
- 🔗 **Integração com API da Marvel:** Consome endpoints da API pública da Marvel para obter informações sobre heróis, quadrinhos, séries, etc.
- ✅ **Testes Unitários:** Implementação de testes unitários para as partes críticas do app usando **JUnit** e **Mockito**.

---

## 🛠️ **Tecnologias Utilizadas**

- **Linguagem de Programação:** Kotlin 🧑‍💻
- **Arquitetura:** Clean Architecture + MVVM (Model-View-ViewModel) 🏗️
- **Bibliotecas e Frameworks:**
  - 🔌 **Retrofit:** Comunicação com a API.
  - 🔄 **Coroutines:** Operações assíncronas.
  - 🖼️ **Glide:** Carregamento e exibição de imagens.
  - 🔍 **Mockito/JUnit:** Testes unitários.
  - 📜 **Paging3/RecyclerView:** Exibição eficiente de listas.

---

## ▶️ **Executando o Projeto**

### ⚙️ Configuração da API da Marvel

Para utilizar a API da Marvel no projeto, é necessário configurar suas chaves API no arquivo `local.properties`.

#### Passo 1: Obtenha suas chaves da API Marvel
1. Crie uma conta no [Marvel Developer Portal](https://developer.marvel.com).
2. Gere um novo par de chaves (pública e privada) na seção "My API Keys".
3. Guarde essas chaves em local seguro.

#### Passo 2: Configure o arquivo `local.properties`
1. No diretório raiz do projeto, crie ou edite o arquivo `local.properties`.
2. Adicione as seguintes linhas ao arquivo:
PUBLIC_KEY="{SUA_CHAVE_PUBLICA}"
PRIVATE_KEY="{SUA_CHAVE_PRIVADA}"

#### Passo 3: Certifique-se de que o arquivo `local.properties` não seja incluído no controle de versão (verifique o `.gitignore`).

Pronto! Agora você pode rodar o projeto no Android Studio. 🚀

---

## 🔗 **Links Úteis**

Aqui estão alguns recursos úteis para ajudar no desenvolvimento:

- [Nested RecyclerView no Android](https://medium.com/nerd-for-tech/nested-recyclerview-in-android-e5afb2b9771a)
- [Documentação do Retrofit](https://square.github.io/retrofit/)
- [Primeiros passos com Detekt](https://munstein.medium.com/primeiros-passos-com-detekt-10416fc90638)
- [Armazenando Chaves Secretas no Android](https://guides.codepath.com/android/Storing-Secret-Keys-in-Android)
- [Clean Architecture e MVVM no Desenvolvimento Android](https://medium.com/@cardosof.gui/clean-architecture-e-mvvm-no-desenvolvimento-android-6f542d0f2e99)

---

💡 *Dica:* Mergulhe no universo Marvel enquanto aprende mais sobre desenvolvimento Android! 😄

