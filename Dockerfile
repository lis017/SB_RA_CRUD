#도커허브에서 os랑 java버전 정해진거 가져와서 여기부터 시작 이란 뜻.
FROM amazoncorretto:21.0.4
#리눅스의 /app안에서 행동해라.
WORKDIR /app
#현재 내 intllij파일경로를 이동한 /app의 리눅스 내의 경로에 카피해라 인듯
COPY . .
#명령어 실행? 그레이들 실행해서 jar파일 만들어라
RUN ./gradlew build
#dockerfile의 마지막 명령어 = CMD / 명령어 실행을 따운표로 나눈것.
CMD ["java", "-jar", ".jar파일경로"] 