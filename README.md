# BabyCube Minecraft

Minecraft server and microservices architecture for learning and some fun.
By Lucas Madranges.

The application is just a learn project, not a real project.

## Summary
- [Applications](#applications)
- [Stack](#stack)
- [How to config](#how-to-config-the-different-env-file)
- [How to start](#how-to-start-the-project)
- [Link](#link)
- [Any problems ?](#any-problem-)

## Applications
- **App Web** : Used for present the server, create user account or link it to the minecraft account, purchase vip items or rank and many more.
- **App Mobile** : Used for see the statistics of each activity, and maybe purchase items.
- **App Desktop** : Used for administrate the list of items, forum, blogs for the moderators and administrators.

## Stack
(non exhaustive-list)
- **App Web** :
    - ![Next.js Badge](https://img.shields.io/badge/Next.js-000?logo=nextdotjs&logoColor=fff&style=for-the-badge)
    - ![React Badge](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000&style=for-the-badge)
    - ![Apollo GraphQL Badge](https://img.shields.io/badge/Apollo%20GraphQL-311C87?logo=apollographql&logoColor=fff&style=for-the-badge)

- **App Mobile** :
    - ![React Badge](https://img.shields.io/badge/React%20Native-61DAFB?logo=react&logoColor=000&style=for-the-badge)

- **App Desktop** :
    - ![Electron Badge](https://img.shields.io/badge/Electron-47848F?logo=electron&logoColor=fff&style=for-the-badge)

- **Gateway and microservices** :
    - ![NestJS Badge](https://img.shields.io/badge/NestJS-E0234E?logo=nestjs&logoColor=fff&style=for-the-badge)
    - ![GraphQL Badge](https://img.shields.io/badge/GraphQL-E10098?logo=graphql&logoColor=fff&style=for-the-badge)
    - ![Prisma Badge](https://img.shields.io/badge/Prisma-2D3748?logo=prisma&logoColor=fff&style=for-the-badge)
    - ![Apollo GraphQL Badge](https://img.shields.io/badge/Apollo%20GraphQL-311C87?logo=apollographql&logoColor=fff&style=for-the-badge)

- **Database** :
    - ![PostgreSQL Badge](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=fff&style=for-the-badge)

- **Tools** :
    - ![Docker Badge](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff&style=for-the-badge)

## How to config the different env files
- Some of it, change the (ENV) by the env corresponding.

- Gateway :
  - DATABASE_URL=postgresql://(POSTGRES_USER):(POSTGRES_PASSWORD)@babycube-db:5432/(POSTGRES_DB)

- Database :
  - POSTGRES_USER
  - POSTGRES_PASSWORD
  - POSTGRES_DB

## How to start the project

To start the entire project, you have to install docker and docker-compose on your computer :
- [Docker](https://www.docker.com/)
- [Docker compose](https://docs.docker.com/compose/)

Then, set your terminal on the root project and write this command :

```docker compose up --build```

Launch it, the project will start quickly. Enjoy!

## Link

- App Web : [https://localhost:3000](https://localhost:3000)
- App Mobile : WIP
- App Desktop : WIP
- Gateway : [https://localhost:4000](https://localhost:4000)

## Any problem ?

Go to the issues section [here](https://github.com/LucasMadranges/BabyCube/issues) and create new issue if you see some bugs or problem on the project. Thanks!