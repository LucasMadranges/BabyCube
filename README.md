# BabyCube Minecraft

Minecraft server and microservices architecture for learning and some fun.
By Lucas Madranges.

The application is just a learn project, not a real project.

## Summary

- [Applications](#applications)
- [Stack](#stack)
- [How to config](#how-to-config-the-different-env-files)
- [How to start](#how-to-start-the-project)
    - [AppWeb + Gateway & Services + DB + Minecraft Server](#appweb--gateway--services--db--minecraft-server)
        - [Gateway](#gateway)
        - [AppWeb](#appweb)
        - [Minecraft Server](#minecraft-server)
    - [App Mobile](#app-mobile)
    - [App Desktop](#app-desktop)
- [Any problems ?](#any-problem-)

## Applications

- **App Web** : Used for present the server, create user account or link it to the minecraft account, purchase vip items
  or rank and many more.
- **App Mobile** : Used for see the statistics of each activity, and maybe purchase items.
- **App Desktop** : Used for administrate the list of items, forum, blogs for the moderators and administrators.

## Stack

(non exhaustive list)

- **App Web** :
    - ![Next.js Badge](https://img.shields.io/badge/Next.js-000?logo=nextdotjs&logoColor=fff&style=for-the-badge)
    - ![React Badge](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000&style=for-the-badge)
    - ![Apollo GraphQL Badge](https://img.shields.io/badge/Apollo%20GraphQL-311C87?logo=apollographql&logoColor=fff&style=for-the-badge)

- **App Mobile** :
    - ![React Native Badge](https://img.shields.io/badge/React%20Native-61DAFB?logo=react&logoColor=000&style=for-the-badge)

- **App Desktop** :
    - ![Electron Badge](https://img.shields.io/badge/Electron-47848F?logo=electron&logoColor=fff&style=for-the-badge)
    - ![React Badge](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000&style=for-the-badge)

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

Some of it, change the (ENV) by the env corresponding.

- Platforms/Applications/AppWeb/.env.local :

```Nothing to do```

- Platforms/Applications/Mobile/.env :

```Nothing to do```

- Platforms/Applications/Desktop/.env :

```Nothing to do```

- Platforms/Server/Services/.env :

```
NODE_ENV=dev

DATABASE_URL=postgresql://(POSTGRES_USER):(POSTGRES_PASSWORD)@babycube-db:5432/(POSTGRES_DB)

PORT_GATEWAY=4000
PORT_USERS=4001
PORT_POSTS=4002

APOLLO_KEY
```

- Platforms/DB/.env :

```
POSTGRES_USER 
POSTGRES_PASSWORD
POSTGRES_DB
```

## How to start the project

### AppWeb + Gateway & Services + DB + Minecraft Server

To start the entire project, you have to install docker and docker-compose on your computer :

- [Docker](https://www.docker.com/)
- [Docker compose](https://docs.docker.com/compose/)

Then, set your terminal on the root project and write this command :

```docker compose up --build```

Launch it, the project will start quickly and node_modules will be installed. Enjoy!

#### Gateway

Go to [https://localhost:4000](https://localhost:4000) for the back. You should see something.

#### AppWeb

Go to [https://localhost:3000](https://localhost:3000) for the front. You
should see something.

#### Minecraft Server

Go to (your ip adress):45000 on Minecraft, the server should be online.

### App Mobile

Before launch the app, you have to install a simulator with Xcode (Apple) or Android Studio (Apple, Windows & Linux) on
your computer.
Or, you can install Expo go directly on your phone for testing the mobile app.

Here a link to the documentation of React native to start
with : [Environment setup - React Native](https://reactnative.dev/docs/environment-setup)

When you have finished, open your terminal on the root project and write this command :

```cd Platform/Applications/Mobile && npm i && npm run start```

You should see something on your terminal with a list of commands with those three :

- › Press a │ open Android
- › Press i │ open iOS simulator
- › Press w │ open web

Press any touch has you want for test the app. Enjoy!

### App Desktop

Open your terminal on the root project and write this command :

```cd Platform/Applications/Desktop && npm i && npm run start```

You should see something appeared on your computer. Enjoy!

## Any problem ?

Go to the issues section [here](https://github.com/LucasMadranges/BabyCube/issues) and create new issue if you see some
bugs or problem on the project. Thanks!