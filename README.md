# CliniVida - Sistema de Agendamentos Médicos

CliniVida — sistema simples de gestão para clínica (Pacientes, Médicos e Consultas). Projeto de estudo de caso para a disciplina — implementação usando Java 21, Spring Boot, Thymeleaf, Spring Data JPA, Hibernate e Bootstrap. Suporta banco em H2 (in-memory) para desenvolvimento rápido e em MariaDB para produção/avaliação.

## 🩺 Objetivo do Sistema
O sistema CliniVida foi desenvolvido para permitir o cadastro, consulta, edição e exclusão de pacientes, médicos e consultas médicas, em uma interface web simples e responsiva. O sistema utiliza autenticação, design moderno e integração com banco de dados.

## 🚀 Tecnologias Utilizadas
• Java 21  
• Spring Boot 3.1.6  
• Spring Data JPA  
• Spring Security  
• Thymeleaf  
• Bootstrap 5  
• Lombok  
• H2 Database (dev)  
• MariaDB (produção)  

## 📂 Estrutura de Pastas
src/main/java/br/uern/clinivida/
│
├── controller/ → Controladores (Home, Paciente, Médico, Consulta)
├── model/ → Entidades JPA (Paciente, Medico, Consulta, Usuario)
├── repository/ → Interfaces de acesso ao banco
├── service/ → Regras de negócio
├── config/ → Configurações de segurança e DataLoader
└── CliniVidaApplication.java → Classe principal

src/main/resources/
├── templates/ → Páginas Thymeleaf (login, home, pacientes, médicos, consultas)
├── static/css/ → Estilos (Bootstrap)
├── application.properties
├── application-h2.properties
└── application-mariadb.properties

## ⚙️ Perfis de Execução
O sistema pode ser executado tanto com o H2 quanto com o MariaDB, bastando mudar o perfil ativo.

### 🔹 1. Usando o H2 (mais simples)
No arquivo application.properties, deixe assim:
spring.profiles.active=h2

Execute a aplicação e acesse:
• Sistema: http://localhost:8080/login  
• Console H2: http://localhost:8080/h2-console  

### 🔹 2. Usando o MariaDB
No arquivo application.properties, altere para:
spring.profiles.active=mariadb

#### Configuração do application-mariadb.properties
spring.datasource.url=jdbc:mariadb://localhost:3306/clini_vida?useSSL=false
spring.datasource.username=root
spring.datasource.password=SUA-SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#### Banco de dados
CREATE DATABASE clini_vida CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL PRIVILEGES ON clini_vida.* TO 'root'@'localhost' IDENTIFIED BY 'Mariadev012%';
FLUSH PRIVILEGES;

Abaixo está o passo a passo de como acessar o MariaDB, criar o banco de dados do sistema e configurar o usuário com permissões adequadas:

### Abrindo o MariaDB pelo Terminal cmd do windowns
C:\Windows\system32\cmd.exe - "C:\Program Files\MariaDB 12.0\bin\mysql" -u root -p --port=3306

Explicação linha por linha pra entender melhor essa parte:

| Trecho | Significado |
|--------|-------------|
| C:\Windows\system32\cmd.exe | Indica que o terminal (Prompt de Comando) está sendo usado. |
| "C:\Program Files\MariaDB 12.0\bin\mysql" | Caminho para o executável do cliente mysql do MariaDB. |
| -u root | Especifica o usuário que fará o login (no caso, o usuário administrador root). |
| -p | Indica que será solicitada a senha após pressionar Enter. |
| --port=3308 | Informa que o MariaDB está rodando na porta 3306 (e não na porta padrão 3306). |

Após executar o comando, o terminal pedirá a senha:
Enter password: ************

Se estiver tudo certo, você verá o monitor do MariaDB aberto.

### Criando o Banco de Dados
CREATE DATABASE clini_vida CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

Explicação:
• CREATE DATABASE clini_vida → Cria um banco chamado clini_vida.  
• CHARACTER SET utf8mb4 → Define suporte total a caracteres (inclui emojis e acentos sem erro).  
• COLLATE utf8mb4_general_ci → Define a forma como strings serão comparadas (ignora maiúsculas/minúsculas).  

### Criando o Usuário do Sistema
CREATE USER 'clinividabot'@'localhost' IDENTIFIED BY 'SenhaClinivida123';

Explicação:
• clinividabot → Nome do usuário do sistema.  
• @'localhost' → Só pode acessar localmente.  
• IDENTIFIED BY 'SenhaClinivida123' → Senha do usuário.  

### Dando Permissões ao Usuário
GRANT ALL PRIVILEGES ON clini_vida.* TO 'clinividabot'@'localhost';

Explicação:
• Dá total permissão (criar, ler, atualizar, deletar) para todas as tabelas do banco clini_vida ao usuário clinividabot.  

### Confirmando as Permissões
FLUSH PRIVILEGES;

Explicação:
• Atualiza as permissões para que passem a valer imediatamente.  

### Verificando se o Banco Foi Criado
SHOW DATABASES;

Explicação:
• Lista todos os bancos existentes.  
• Se tudo estiver certo, clini_vida deverá aparecer na lista da seguinte forma:

MariaDB [(none)]> Verifica se o banco foi criado
MariaDB [(none)]> SHOW DATABASES;
| Database
clini_vida
information_schema
mysql
performance_schema
sys
5 rows in set (0.004 sec)

MariaDB [(none)]> USE clini_vida;
Database changed

MariaDB [clini_vida]> SHOW TABLES;
| Tables_in_clini_vida |
consulta
medico
paciente
usuario
4 rows in set (0.001 sec)

MariaDB [clini_vida]> SELECT * FROM paciente;
| id | cpf endereco | nome telefone
2 NULL jose maria 88888888888 99999999999
NULL joão 88888888888
2 rows in set (0.000 sec)

MariaDB [clini_vida]> SELECT * FROM consulta;
id data | hora | observacoes | medico_id | paciente te_id
1 1 | 1 | 2025-11-04 | 01:00:00.000000 | paciente se queixando de dor no peito
1 row in set (0.000 sec)

MariaDB [clini_vida]>

✅ Pronto! Agora o banco está criado, com usuário configurado e permissões aplicadas para uso pelo sistema.

## 🔐 Login padrão
| Usuário | Senha |
|---------|-------|
| admin   | 123   |

O usuário é criado automaticamente pelo sistema na primeira execução.

## 🧠 Funcionalidades Principais
✅ Login seguro com autenticação Spring Security  
✅ Menu lateral fixo (Home, Pacientes, Médicos, Consultas)  
✅ CRUD completo:  
  • Pacientes → cadastrar, editar, excluir e listar  
  • Médicos → cadastrar, editar, excluir e listar  
  • Consultas → agendar, editar, excluir e verificar conflitos  
✅ Integração visual entre as telas  
✅ Design moderno com Bootstrap  
✅ Alternância de banco H2 ↔ MariaDB sem perder dados  

• Explicando a lógica do sistema:  
O sistema só permite apagar médicos e pacientes que não possuem consultas agendadas. Para apagar médicos e pacientes que possuem consultas agendadas, primeiro você tem que apagar a consulta relativo a esse medico e paciente.

## 🪄 Como Executar o Projeto
1. Abrir no Eclipse (Enterprise Edition)
2. Certifique-se de ter o Lombok instalado
3. Verifique se o Java 21 está configurado no projeto
4. Escolha o perfil no application.properties (H2 ou MariaDB)
5. Clique com o botão direito no projeto → Run As → Spring Boot App
6. Acesse no navegador: http://localhost:8080

## 🧩 Erros Comuns e Soluções
• Usuário ou senha inválidos: Apague o banco clini_vida no MariaDB e rode o sistema novamente (o admin será recriado).  
• Porta 8080 ocupada: Mude a porta no application.properties:  
  • server.port=8081  
• Erro ao conectar no banco: Verifique se o MariaDB está rodando e se o login/senha estão corretos.  

## 👨‍💻 Autor
Willian Fernandes Paiva  
Estudo de caso — Sistema CliniVida  
Disciplina de Desenvolvimento de Sistemas Corporativos  
Universidade do Estado do Rio Grande do Norte (UERN)

## 💡 Observação final
Este projeto segue o modelo proposto no tutorial da empresa fictícia TransCarga, adaptado para o contexto de uma clínica médica.
