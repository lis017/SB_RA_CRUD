#최적화 방식으로 도커파일 구현(multi-stage식)(이미지 용량 줄이기)



#도커허브에서 os랑 java버전 정해진거 가져와서 여기부터 시작 이란 뜻.
#as는 내가 이름짓는것
#os랑 java21버전 다운받은것.
FROM amazoncorretto:21.0.4 AS build
#리눅스의 /app안에서 행동해라.
WORKDIR /app
#현재 내 intllij파일경로를 이동한 /app의 리눅스 내의 경로에 카피해라 인듯
COPY . .
#명령어 실행? 그레이들 실행해서 jar파일 만들어라
RUN ./gradlew build



#아래 코드블럭은, jar파일을 만든후, 최적화를위해 os다시설치하고 어쩌구해서, 결국 jar파일만 가지고갈수있게(jar만 있어도 되니깐) 한것
#결국 os, java21, jar파일만 존재하고, jar파일을 실행하는 도커파일코드 완성(최적화)

#기존거 지우고 새로 이미지 시작
FROM amazoncorretto:21.0.4 AS runtime
WORKDIR /app
#빌드 이미지(이전)에 /app/build/libs/*.jar 경로에 있던걸 /app/server.jar 로 옮겨라. 라는뜻.
COPY --from=build /app/build/libs/*.jar /app/server.jar
#dockerfile의 마지막 명령어 = CMD / 명령어 실행을 따운표로 나눈것.
CMD ["java", "-jar", "/app/server.jar"]



