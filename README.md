# 📱 Mobile Cadastro de Usuário - Android Nativo

Este projeto é uma aplicação Android desenvolvida em **Java** que serve como um guia prático para a implementação de fluxos de cadastro, manipulação de listas dinâmicas com `RecyclerView` e gerenciamento de estado entre telas.

---

## 📖 Visão Geral do Projeto

O objetivo deste aplicativo é permitir que o usuário cadastre informações básicas (Nome e E-mail) e visualize esses dados instantaneamente em uma lista organizada na tela principal. O projeto foca em fundamentos de arquitetura Android, como o ciclo de vida das Activities e a eficiência de renderização.

---

## 🛠️ Detalhamento Técnico da Implementação

### 1. `MainActivity.java` (O Centro de Controle)
Esta Activity é responsável por orquestrar a exibição dos dados.
*   **Persistência de Dados:** Utiliza uma `public static List<String> listaNomes`. A escolha do modificador `static` permite que os dados persistam na memória durante a sessão do aplicativo, sendo acessíveis de forma direta por outras telas sem a complexidade de Serialização/Parcelable neste estágio inicial.
*   **Gerenciamento do RecyclerView:** 
    *   Configura um `LinearLayoutManager` para garantir uma rolagem vertical fluida.
    *   Inicializa o `UserAdapter` injetando a fonte de dados.
*   **Ciclo de Vida (`onResume`):** Implementa a atualização reativa. Ao retornar da tela de cadastro, o método `adapter.notifyDataSetChanged()` é invocado para redesenhar a lista com os novos dados inseridos.

### 2. `CreateUser.java` (Interface de Entrada)
Activity dedicada à interação do usuário e coleta de dados.
*   **Componentes Material Design:** Uso de `TextInputEditText` para entradas de texto, proporcionando validações visuais e labels flutuantes.
*   **Lógica de Negócio:**
    *   Valida se o campo de nome foi preenchido.
    *   Concatena o nome e o e-mail em uma única String para exibição simplificada.
    *   Utiliza o método `finish()` para encerrar a tela após o salvamento, otimizando o uso da pilha de Activities.

### 3. `UserAdapter.java` (Motor de Renderização)
Implementação customizada do padrão Adapter para o `RecyclerView`.
*   **Padrão ViewHolder:** Criado para evitar chamadas excessivas ao método `findViewById`, o que melhora significativamente a performance em listas longas.
*   **Layout Nativo:** Utiliza o `android.R.layout.simple_list_item_1` para garantir uma interface limpa e compatibilidade imediata com o tema do sistema.

---

## 🎨 Layouts (Interface Gráfica)

### **`activity_main.xml`**
*   Baseado em `ConstraintLayout`.
*   **RecyclerView:** Ocupa a área central da tela para exibição dos nomes.
*   **Botão Cadastrar:** Posicionado estrategicamente na parte inferior para fácil acesso.

### **`create_user.xml`**
*   Estruturado para clareza visual.
*   Inclui campos para Nome Completo e E-mail, além de um botão de ação "Salvar".

---

## ⚡ Tecnologias e Conceitos Aplicados

*   **Java 8+:** Uso de **Expressões Lambda** para listeners de clique, tornando o código mais legível e moderno.
*   **Android Jetpack:** Uso de `AppCompatActivity` e `ConstraintLayout`.
*   **Google Material Components:** Botões e campos de texto padronizados.
*   **Intents:** Sistema de mensagens do Android para navegação entre telas.

---

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [url-do-repositorio]
    ```
2.  **Abra no Android Studio:** Certifique-se de estar usando a versão **Ladybug** ou superior.
3.  **Sincronização:** O projeto baixará automaticamente as dependências do `AppCompat`, `ConstraintLayout` e `Material Design`.
4.  **Execução:** Clique no botão **Run** e selecione um emulador ou dispositivo físico com **API 24+ (Android 7.0)**.

---

## 📌 Evolução do Projeto (Próximos Passos)

Para elevar o nível técnico deste projeto, as próximas implementações planejadas são:
1.  **Room Database:** Substituir a lista estática por persistência em banco de dados local (SQLite).
2.  **View Binding:** Eliminar o `findViewById` para aumentar a segurança do código em tempo de compilação.
3.  **Modelos de Dados:** Criar uma classe `User.java` para tratar Nome e Email como objetos, em vez de Strings concatenadas.

---
*Desenvolvido por João Felipe & Vinicius - Foco em excelência no desenvolvimento Android Nativo.*
