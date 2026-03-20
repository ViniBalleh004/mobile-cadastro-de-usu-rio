# Projeto Cadastro de Usuário

Este é um aplicativo Android simples desenvolvido para realizar o cadastro de usuários e exibi-los em uma lista.

## Como o projeto funciona

O aplicativo permite que o usuário navegue entre duas telas principais:
1. **Tela Principal (MainActivity):** Exibe uma lista de usuários cadastrados utilizando um `RecyclerView`. Possui um botão para acessar a tela de cadastro.
2. **Tela de Cadastro (CreateUser):** Oferece campos de entrada para o nome e e-mail do usuário. Ao clicar em "Salvar", os dados são adicionados à lista e o usuário retorna à tela principal.

## Descrição das Classes

### 1. MainActivity.java
Esta é a atividade principal do aplicativo.
- **Função:** Gerenciar a visualização da lista de usuários.
- **Componentes:** Contém um `RecyclerView` para listar os itens e um botão que inicia a `CreateUser` activity.

### 2. CreateUser.java
Esta classe é responsável pela interface de cadastro de novos usuários.
- **Função:** Capturar as informações digitadas pelo usuário (Nome e E-mail).
- **Lógica:** Valida se o campo de nome não está vazio e, teoricamente, adiciona as informações a uma lista compartilhada antes de fechar a tela (`finish()`).

### 3. UserAdapter.java
Esta classe atua como um intermediário entre a fonte de dados e o `RecyclerView`.
- **Função:** Converter os dados de cada usuário em visualizações (Views) que podem ser exibidas dentro da lista na `MainActivity`.
- **Status:** Atualmente em desenvolvimento para integrar a lógica de exibição.

---
*Nota: O projeto utiliza componentes do Android Jetpack como AppCompat e Material Design para uma interface moderna.*
