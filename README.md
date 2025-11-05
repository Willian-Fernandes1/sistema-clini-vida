
---

**📄 Passo a passo para criar o arquivo README.txt:**

1. No Eclipse, clique com o botão direito no seu projeto → **New → File**
2. Nomeie o arquivo como **README.txt**
3. Cole o conteúdo abaixo completo
4. Salve (Ctrl+S)

---

```markdown
# 🩺 CliniVida - Sistema de Agendamentos Médicos

**CliniVida** é um sistema simples de gestão para clínica (Pacientes, Médicos e Consultas).  
Projeto de estudo de caso da disciplina — implementação usando **Java 21, Spring Boot, Thymeleaf, Spring Data JPA, Hibernate e Bootstrap**.  
Suporta banco **H2 (in-memory)** para desenvolvimento rápido e **MariaDB** para produção.

---

## 🎯 Objetivo do Sistema
O sistema CliniVida foi desenvolvido para permitir o **cadastro, consulta, edição e exclusão** de pacientes, médicos e consultas médicas, em uma interface web moderna e responsiva.  
Possui autenticação segura, design moderno e integração completa com banco de dados.

---

## 🚀 Tecnologias Utilizadas
- Java 21  
- Spring Boot 3.1.6  
- Spring Data JPA  
- Spring Security  
- Thymeleaf  
- Bootstrap 5  
- Lombok  
- H2 Database (desenvolvimento)  
- MariaDB (produção)

---

## 📁 Estrutura de Pastas

```

src/main/java/br/uern/clinivida/
├── controller/      → Controladores (Home, Paciente, Médico, Consulta)
├── model/           → Entidades JPA (Paciente, Medico, Consulta, Usuario)
├── repository/      → Interfaces de acesso ao banco
├── service/         → Regras de negócio
├── config/          → Configurações de segurança e DataLoader
└── CliniVidaApplication.java → Classe principal

src/main/resources/
├── templates/       → Páginas Thymeleaf (login, home, pacientes, médicos, consultas)
├── static/css/      → Estilos (Bootstrap)
├── application.properties
├── application-h2.properties
└── application-mariadb.properties

```

---

## ⚙️ Perfis de Execução

### 🔹 1. Usando o H2 (modo simples para testes)
No arquivo **application.properties**, defina:
```

spring.profiles.active=h2

```

Execute a aplicação e acesse:
- Sistema: [http://localhost:8080/login](http://localhost:8080/login)
- Console H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

### 🔹 2. Usando o MariaDB (modo produção)
No arquivo **application.properties**, defina:
```

spring.profiles.active=mariadb

```

#### Configuração do `application-mariadb.properties`:
```

spring.datasource.url=jdbc:mariadb://localhost:3308/clini_vida?useSSL=false
spring.datasource.username=root
spring.datasource.password=Mariadev012%
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

---

## 🧩 Criando o Banco de Dados no MariaDB

### 1️⃣ Acesse o terminal:
```

"C:\Program Files\MariaDB 12.0\bin\mysql" -u root -p --port=3308

````

Digite a senha **Mariadev012%**.

### 2️⃣ Crie o banco de dados:
```sql
CREATE DATABASE clini_vida CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
````

### 3️⃣ Garanta permissões totais:

```sql
GRANT ALL PRIVILEGES ON clini_vida.* TO 'root'@'localhost' IDENTIFIED BY 'Mariadev012%';
FLUSH PRIVILEGES;
```

### 4️⃣ Verifique se foi criado:

```sql
SHOW DATABASES;
USE clini_vida;
SHOW TABLES;
```

✅ Se aparecerem as tabelas `paciente`, `medico`, `consulta`, e `usuario`, tudo está funcionando corretamente!

---

## 🔐 Login Padrão

| Usuário | Senha |
| ------- | ----- |
| admin   | 123   |

> O usuário `admin` é criado automaticamente na primeira execução do sistema.

---

## 🧠 Funcionalidades Principais

✅ Login seguro com **Spring Security**
✅ Menu lateral fixo com design moderno
✅ CRUD completo:

* **Pacientes:** cadastrar, editar, excluir e listar
* **Médicos:** cadastrar, editar, excluir e listar
* **Consultas:** agendar, editar, excluir e verificar conflitos

✅ Integração visual entre as telas
✅ Design moderno com **Bootstrap**
✅ Alternância de banco **H2 ↔ MariaDB** sem perder dados

> O sistema só permite apagar médicos e pacientes que **não possuem consultas agendadas**.

---

## 💻 Como Executar o Projeto

1. **Abra o projeto no Eclipse (Enterprise Edition)**
2. Certifique-se de ter o **Lombok** instalado
3. Verifique se o **Java 21** está configurado
4. Escolha o perfil no `application.properties` (`h2` ou `mariadb`)
5. Execute: **Run As → Spring Boot App**
6. Acesse: [http://localhost:8080](http://localhost:8080)

---

## ⚠️ Erros Comuns e Soluções

| Erro                       | Causa                         | Solução                                                 |
| -------------------------- | ----------------------------- | ------------------------------------------------------- |
| Usuário ou senha inválidos | Banco corrompido              | Apague o banco e reinicie o sistema                     |
| Porta 8080 ocupada         | Outro processo usando a porta | Adicione `server.port=8081` no `application.properties` |
| Erro ao conectar no banco  | MariaDB inativo               | Verifique se o MariaDB está rodando e a senha correta   |

---

## 👨‍💻 Autor

**Willian Fernandes Paiva**
Estudo de Caso — *Sistema CliniVida*
Disciplina: Desenvolvimento de Sistemas Corporativos
Universidade do Estado do Rio Grande do Norte (UERN)

---

## 💡 Observação Final

Este projeto segue o modelo proposto no tutorial da empresa fictícia **TransCarga**,
adaptado para o contexto de uma clínica médica.

```

---

