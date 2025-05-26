# oficina-bicicleta

Sistema de Gerenciamento de Oficina de Bicicletas
Descrição do Projeto
O projeto consiste no desenvolvimento de um sistema web completo para gerenciamento de uma oficina de
bicicletas. A aplicação contempla funcionalidades voltadas tanto para os usuários finais (clientes) quanto
para os administradores (oficineiros/gerentes), com o objetivo de organizar atendimentos, produtos, vendas
e solicitações de manutenção de forma digital, acessível e segura.
Funcionalidades para o Usuário
- Cadastro e login de usuários
- Página inicial personalizada com boas-vindas
- Solicitação de serviços de manutenção para sua bicicleta em andamento.
- Compra de produtos e peças disponíveis na loja em andamento.
Funcionalidades para o Administrador em andamento.
- Acesso à área administrativa em andamento.
- Cadastro, edição e exclusão de usuários em andamento.
- Cadastro, edição e remoção de produtos e serviços
- Controle de estoque e vendas em andamento. 
- Visualização de solicitações de manutenção feitas pelos clientes em andamento.
Tecnologias Utilizadas
Frontend (Interface do Usuário):
- Angular 18 (framework moderno baseado em TypeScript)
- Componentes Standalone
- Angular Forms (formulários reativos)
- Angular Router (roteamento de páginas)
- HTML5 e CSS3
- LocalStorage para armazenar temporariamente o nome do usuário logado
Backend (Servidor da Aplicação):

- Java com Spring Boot
- APIs REST
- Autenticação e controle de acesso
- Conexão com banco de dados via JPA/Hibernate
Banco de Dados:
- MySQL
Segurança
Implementação de autenticação com tokens JWT (JSON Web Tokens) para proteger as rotas e garantir que
apenas usuários autenticados acessem determinadas funcionalidades.
Comunicação Frontend <-> Backend
A comunicação entre o Angular e o Spring Boot é feita por meio de requisições HTTP (usando o HttpClient),
respeitando o padrão REST, o que torna o sistema escalável e modular.
